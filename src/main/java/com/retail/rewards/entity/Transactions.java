package com.retail.rewards.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "transaction_amount")
    private Double amount;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    public void setTransactionDate(LocalDate transactionDate){
        this.transactionDate = transactionDate;
    }

    public long getCustomerId(){
        return customerId;
    }

    public Double getAmount(){
        return amount;
    }

    public LocalDate getTransactionDate(){
        return transactionDate;
    }

}
