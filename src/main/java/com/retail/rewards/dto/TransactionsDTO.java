package com.retail.rewards.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionsDTO {

    Double amount;
    String transactionId;
    LocalDate transactionDate;
    int pointsEarned;

    public TransactionsDTO(Double amount, String transactionId, LocalDate transactionDate, int pointsEarned) {
        this.amount = amount;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.pointsEarned = pointsEarned;
    }
}
