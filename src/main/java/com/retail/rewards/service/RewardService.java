package com.retail.rewards.service;

import com.retail.rewards.entity.Customers;
import com.retail.rewards.entity.Transactions;
import com.retail.rewards.repository.CustomersRepository;
import com.retail.rewards.repository.TransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RewardService {

    private final Logger log = LoggerFactory.getLogger(RewardService.class);

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public void getRewards(Long customerId, LocalDate toDate , LocalDate fromDate) throws Exception {
        Optional<Customers> customer = customersRepository.findById(customerId);
        if(!customer.isPresent()){
            System.out.println("Customer is not found...");
            throw new Exception("Customer not found....");
        }
        Customers customer1 = customer.get();
        String customerName = customer1.getName();
        log.info("Fetching the transaction details for the customer :: {}",customerName);

        List<Transactions> transactions = transactionsRepository.findByCustomerId(customerId);
        int totalPointsEarned = transactions.stream().map(it->calculateRewards(it.getAmount())).reduce(0, Integer::sum);
        log.info("Total reward points earned by the customer in past three months is :: {}",totalPointsEarned);

    }

    private int calculateRewards(Double amount){
        int totalPoints = 0;
        if(amount>100){
            totalPoints+=(amount-100)*2;
            amount = 100.0;
        }
        if(amount>=50)
            totalPoints+=(amount-50);
        return totalPoints;
    }
}
