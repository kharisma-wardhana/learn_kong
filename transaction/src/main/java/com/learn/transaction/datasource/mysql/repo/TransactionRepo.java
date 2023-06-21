package com.learn.transaction.datasource.mysql.repo;

import com.learn.transaction.datasource.mysql.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
