package com.retail.rewards.Exception;

import lombok.Getter;

@Getter
public class CustomerNotFoundException  extends RuntimeException{

    private final String customerId;

    public CustomerNotFoundException(String message,String customerId){
        super(message);
        this.customerId = customerId;
    }

}
