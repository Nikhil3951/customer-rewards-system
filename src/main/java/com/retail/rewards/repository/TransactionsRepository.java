package com.retail.rewards.repository;

import com.retail.rewards.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

    List<Transactions> findByCustomerId(Long customer_id);
}
