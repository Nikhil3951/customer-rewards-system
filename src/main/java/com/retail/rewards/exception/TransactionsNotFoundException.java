package com.retail.rewards.exception;

import lombok.Getter;

@Getter
public class TransactionsNotFoundException extends RuntimeException{

    private final String customerId;

    public TransactionsNotFoundException(String message,String customerId){
        super(message);
        this.customerId=customerId;
    }

}
