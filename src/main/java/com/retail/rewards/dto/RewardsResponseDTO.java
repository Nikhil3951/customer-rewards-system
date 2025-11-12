package com.retail.rewards.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RewardsResponseDTO {

    String customerId;
    String customerName;
    String customerEmail;
    int totalRewardPoints;
    Map<String,Integer> monthlyPoints;
    List<TransactionsDTO> transactions;

    public RewardsResponseDTO(String customerId, String customerName, String customerEmail, int totalRewardPoints, Map<String, Integer> monthlyPoints, List<TransactionsDTO> transactions) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.monthlyPoints = monthlyPoints;
        this.transactions = transactions;
        this.totalRewardPoints = totalRewardPoints;
    }
}
