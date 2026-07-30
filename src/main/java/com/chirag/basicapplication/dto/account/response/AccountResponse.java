package com.chirag.basicapplication.dto.account.response;

import com.chirag.basicapplication.entity.Customer;
import com.chirag.basicapplication.entity.Transactions;
import com.chirag.basicapplication.enums.Account_Type;
import com.chirag.basicapplication.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountResponse {

    @Column(unique = true)
    private String account_no;

    private Account_Type accountType;

    private int balance;

    @Enumerated(EnumType.STRING)
    private Status status;

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public Account_Type getAccountType() {
        return accountType;
    }

    public void setAccountType(Account_Type accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @CreationTimestamp
    private LocalDateTime created_at;

//    @JsonIgnore// Creates a foreign key column in this table
    private Customer customer;

//    @JsonIgnore
    private List<Transactions> transactions;
}
