package com.chirag.basicapplication.entity;

import com.chirag.basicapplication.enums.Transaction_Type;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Transaction_Type transactionType;

    private Long amount;

    private Long balance_after;

    private String remarks;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
