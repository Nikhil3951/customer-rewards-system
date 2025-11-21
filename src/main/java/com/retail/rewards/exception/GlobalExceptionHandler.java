package com.retail.rewards.exception;

import com.retail.rewards.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
        ErrorDetails error = new ErrorDetails();
        error.setMessage(customerNotFoundException.getMessage());
        error.setCustomerId(customerNotFoundException.getCustomerId());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionsNotFoundException.class)
    public ResponseEntity<?> handleTransactionsNotFoundException(TransactionsNotFoundException transactionsNotFoundException){
        ErrorDetails error = new ErrorDetails();
        error.setMessage(transactionsNotFoundException.getMessage());
        error.setCustomerId(transactionsNotFoundException.getCustomerId());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception){
        ErrorDetails error = new ErrorDetails();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
