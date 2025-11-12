package com.retail.rewards.service;

import com.retail.rewards.Exception.CustomerNotFoundException;
import com.retail.rewards.Exception.TransactionsNotFoundException;
import com.retail.rewards.constants.Month;
import com.retail.rewards.dto.RewardsResponseDTO;
import com.retail.rewards.dto.TransactionsDTO;
import com.retail.rewards.entity.Customers;
import com.retail.rewards.entity.Transactions;
import com.retail.rewards.repository.CustomersRepository;
import com.retail.rewards.repository.TransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private final Logger log = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public RewardsResponseDTO getRewards(String customerId, LocalDate fromDate, LocalDate toDate) {
        Customers customer = customersRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + customerId,customerId));
        log.info("Customer details :: {}", customer);
        List<Transactions> transactions = fetchTransactions(customerId, fromDate, toDate);
        List<TransactionsDTO> transactionDetails = transactions.stream()
                .map(
                        transaction -> new TransactionsDTO(
                                transaction.getAmount(),
                                transaction.getTransactionId(),
                                transaction.getTransactionDate(),
                                calculateRewards(transaction.getAmount())
                        )
                ).collect(Collectors.toList());

        int totalPointsEarned = transactionDetails.stream().map(TransactionsDTO::getPointsEarned).reduce(0, Integer::sum);
        log.info("Total reward points earned by the customer in past three months is :: {}", totalPointsEarned);

        Map<String, Integer> monthlyPoints = transactionDetails.stream()
                .sorted(Comparator.comparing(TransactionsDTO::getTransactionDate))
                .collect(Collectors.groupingBy(
                        transaction -> Month.getMonth(transaction.getTransactionDate().getMonthValue()),
                        LinkedHashMap::new,
                        Collectors.summingInt(TransactionsDTO::getPointsEarned)
                ));

        return new RewardsResponseDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                totalPointsEarned,
                monthlyPoints,
                transactionDetails
        );
    }

    private List<Transactions> fetchTransactions(String customerId, LocalDate fromDate, LocalDate toDate) {
        List<Transactions> transactions;
        if (toDate != null && fromDate != null) {
            log.info("Fetching the customer transaction details from {} to {}", fromDate, toDate);
            transactions = transactionsRepository.findByCustomerIdAndTransactionDateBetween(customerId, fromDate, toDate);
        } else {
            log.info("Fetching all transactions for customer {} (no date range)", customerId);
            transactions = transactionsRepository.findByCustomerId(customerId);
        }
        if (transactions == null || transactions.isEmpty()) {
            log.warn("No transactions found for customer {} in the given date range", customerId);
            throw new TransactionsNotFoundException("No transactions found for customer " + customerId, customerId);
        }
        return transactions;
    }

    private int calculateRewards(Double amount) {
        int totalPoints = 0;
        if (amount > 100) {
            totalPoints += (int)((amount - 100) * 2);
            amount = 100.0;
        }
        if (amount >= 50)
            totalPoints += (int) (amount - 50);
        return totalPoints;
    }
}
