package com.chirag.basicapplication.entity;

import com.chirag.basicapplication.enums.Transaction_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Transaction_Type transactionType;

    private Long amount;

    private Long balance_after;

    private String remarks;

    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(nullable = false, unique = true)
    private String transactionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;


    @PrePersist
    private void generateTransactionId() {
        if (transactionId == null || transactionId.isBlank()) {
            transactionId = String.valueOf(
                    ThreadLocalRandom.current().nextInt(100000, 1000000)
            );
        }
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction_Type getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Transaction_Type transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBalance_after() {
        return balance_after;
    }

    public void setBalance_after(Long balance_after) {
        this.balance_after = balance_after;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}