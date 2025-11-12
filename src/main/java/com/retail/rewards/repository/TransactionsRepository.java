package com.retail.rewards.repository;

import com.retail.rewards.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,String> {

    List<Transactions> findByCustomerId(String customer_id);


    List<Transactions> findByCustomerIdAndTransactionDateBetween(String customer_id, LocalDate toDate,LocalDate fromDate);
}
