package com.chirag.basicapplication.repository;

import com.chirag.basicapplication.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transactions,Long> {
}
