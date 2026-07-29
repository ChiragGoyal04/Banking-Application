package com.chirag.basicapplication.dto.account.request;

import com.chirag.basicapplication.enums.Account_Type;
import com.chirag.basicapplication.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class CreateAccountRequest {

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

    @Column(unique = true)
    private String account_no;

    private Account_Type accountType;

    private int balance=0;

    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;

    @CreationTimestamp
    private LocalDateTime created_at;

}
