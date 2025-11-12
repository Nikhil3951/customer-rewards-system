package com.retail.rewards.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "transaction_amount")
    private Double amount;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

}
