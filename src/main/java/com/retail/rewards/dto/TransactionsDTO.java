package com.retail.rewards.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TransactionsDTO {

    BigDecimal amount;
    String transactionId;
    LocalDate transactionDate;
    int pointsEarned;

    public TransactionsDTO(BigDecimal amount, String transactionId, LocalDate transactionDate, int pointsEarned) {
        this.amount = amount;
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.pointsEarned = pointsEarned;
    }
}
