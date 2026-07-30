package com.chirag.basicapplication.repository;

import com.chirag.basicapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account,Long> {

    @Query("""
        SELECT a
        FROM Account a
        JOIN a.customer c
        WHERE c.customer_no = :customer_no
    """)
    List<Account> findByCustomerCustomer_no(@Param("customer_no") String customer_no);
}
