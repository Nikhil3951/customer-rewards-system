package com.retail.rewards.service;


import com.retail.rewards.Exception.CustomerNotFoundException;
import com.retail.rewards.Exception.TransactionsNotFoundException;
import com.retail.rewards.dto.RewardsResponseDTO;
import com.retail.rewards.entity.Customers;
import com.retail.rewards.entity.Transactions;
import com.retail.rewards.repository.CustomersRepository;
import com.retail.rewards.repository.TransactionsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RewardServiceTest {

    @Mock
    private CustomersRepository customersRepository;

    @Mock
    private TransactionsRepository transactionsRepository;

    @InjectMocks
    private RewardService rewardService;

    @Test
    void testGetRewardsWithDateRange() {
        String customerId = "CUST001";
        LocalDate fromDate = LocalDate.parse("2025-10-11");
        LocalDate toDate = LocalDate.parse("2025-10-11");
        Optional<Customers> customer = Optional.of(mockCustomer());
        when(customersRepository.findById(customerId)).thenReturn(customer);
        when(transactionsRepository.findByCustomerIdAndTransactionDateBetween(customerId, fromDate, toDate)).thenReturn(mockTransactionswithRange());
        RewardsResponseDTO rewards = rewardService.getRewards(customerId, fromDate, toDate);
        Assertions.assertEquals(160,rewards.getTotalRewardPoints());
        Assertions.assertEquals(customerId,"CUST001");
        Assertions.assertEquals(rewards.getCustomerName(),"John Dae");
        Assertions.assertEquals(rewards.getCustomerEmail(),"johndae@gmail.com");
    }

    @Test
    void testCoverageWithoutDateRange(){
        String customerId = "CUST001";
        Optional<Customers> customer = Optional.of(mockCustomer());
        when(customersRepository.findById(customerId)).thenReturn(customer);
        when(transactionsRepository.findByCustomerId(customerId)).thenReturn(mockTransactions());
        RewardsResponseDTO rewards = rewardService.getRewards(customerId, null, null);
        Assertions.assertEquals(195,rewards.getTotalRewardPoints());
        Assertions.assertEquals(customerId,"CUST001");
        Assertions.assertEquals(rewards.getCustomerName(),"John Dae");
        Assertions.assertEquals(rewards.getCustomerEmail(),"johndae@gmail.com");
    }

    @Test
    void testInvalidCustomer() {
        Optional<Customers> customer = Optional.ofNullable(null);
        when(customersRepository.findById("CUST001")).thenReturn(customer);
        //No dates are parsed with invalid customer
        Assertions.assertThrows(CustomerNotFoundException.class, () -> {
                    rewardService.getRewards("CUST001", null, null);
                }
        );
    }

    @Test
    void testEmptyTransactions() {
        String customerId = "CUST001";
        LocalDate fromDate = LocalDate.parse("2025-10-11");
        LocalDate toDate = LocalDate.parse("2025-11-11");
        Optional<Customers> customer = Optional.of(mockCustomer());
        when(customersRepository.findById(customerId)).thenReturn(customer);
        when(transactionsRepository.findByCustomerIdAndTransactionDateBetween(customerId, fromDate, toDate)).thenReturn(Collections.emptyList());
        Assertions.assertThrows(TransactionsNotFoundException.class, () -> {
                    rewardService.getRewards(customerId, fromDate, toDate);
                }
        );
    }

    private Customers mockCustomer() {
        Customers customer = new Customers();
        customer.setCustomerId("CUST001");
        customer.setName("John Dae");
        customer.setEmail("johndae@gmail.com");
        return customer;
    }

    private List<Transactions> mockTransactionswithRange(){
        Transactions transactionOne = new Transactions();
        transactionOne.setAmount(BigDecimal.valueOf(155.0));
        transactionOne.setTransactionId("TRNX01");
        transactionOne.setTransactionDate(LocalDate.parse("2025-10-10"));
        transactionOne.setCustomerId("CUST001");
        return Collections.singletonList(transactionOne);
    }

    private List<Transactions> mockTransactions() {
        Transactions transactionOne = new Transactions();
        transactionOne.setAmount(BigDecimal.valueOf(155.0));
        transactionOne.setTransactionId("TRNX01");
        transactionOne.setTransactionDate(LocalDate.parse("2025-10-10"));
        transactionOne.setCustomerId("CUST001");

        Transactions transactionTwo = new Transactions();
        transactionTwo.setAmount(BigDecimal.valueOf(85.0));
        transactionTwo.setTransactionId("TRNX02");
        transactionTwo.setTransactionDate(LocalDate.parse("2025-11-11"));
        transactionTwo.setCustomerId("CUST002");

        return Arrays.asList(transactionOne,transactionTwo);
    }
}
