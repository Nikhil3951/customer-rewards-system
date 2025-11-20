package com.retail.rewards.controller;

import com.retail.rewards.dto.RewardsResponseDTO;
import com.retail.rewards.dto.TransactionsDTO;
import com.retail.rewards.service.RewardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RewardControllerTest {

    @InjectMocks
    private RewardController rewardController;

    @Mock
    private RewardService rewardService;

    @Test
    public void testIllegalArguments(){
        String customerId = "CUST001";
        LocalDate fromDate = LocalDate.parse("2025-10-11");
        LocalDate toDate = LocalDate.parse("2025-12-11");
        assertThrows(IllegalArgumentException.class,()-> rewardController.getRewards(customerId,fromDate,toDate));
    }

    @Test
    public void testInvalidInput(){
        String customerId = "CUST001";
        LocalDate fromDate = LocalDate.parse("2025-12-13");
        LocalDate toDate = LocalDate.parse("2025-12-11");
        assertThrows(IllegalArgumentException.class,()-> rewardController.getRewards(customerId,fromDate,toDate));
    }

    @Test
    public void testRewards() throws Exception {
        String customerId = "CUST001";
        LocalDate fromDate = LocalDate.parse("2025-10-13");
        LocalDate toDate = LocalDate.parse("2025-11-11");
        Map<String,Integer> monthlyPoints = mockMonthlyPoints();
        List<TransactionsDTO> transactionDetails = mockTransactions();
        RewardsResponseDTO responseDTO = new RewardsResponseDTO(
                "CUST001",
                "JOHN DAE",
                "johndae@gmail.com",
                32,
                monthlyPoints,
                transactionDetails
        );
        when(rewardService.getRewards(customerId,fromDate,toDate)).thenReturn(responseDTO);
        ResponseEntity<?> result = rewardController.getRewards(customerId,fromDate,toDate);
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody(),responseDTO);
    }

    private Map<String,Integer> mockMonthlyPoints(){
        Map<String,Integer> rewards = new HashMap<>();
        rewards.put("October",20);
        rewards.put("Novembor",12);
        return rewards;
    }

    private List<TransactionsDTO> mockTransactions(){
        List<TransactionsDTO> transactionDetails = new ArrayList<>();
        transactionDetails.add(
                new TransactionsDTO(
                        BigDecimal.valueOf(70.0),
                        "TRNX01",
                        LocalDate.parse("2025-10-13"),
                        20
                )
        );
        transactionDetails.add(
                new TransactionsDTO(
                        BigDecimal.valueOf(62.0),
                        "TRNX01",
                        LocalDate.parse("2025-11-11"),
                        12
                )
        );
        return transactionDetails;
    }

}
