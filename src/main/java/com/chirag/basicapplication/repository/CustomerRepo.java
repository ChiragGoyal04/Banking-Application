package com.chirag.basicapplication.repository;

import com.chirag.basicapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM Customer c WHERE c.customer_no = :customer_no")
    Optional<Customer> findBy(@Param("customer_no") String customer_no);

    void delete(Customer customer);
}
