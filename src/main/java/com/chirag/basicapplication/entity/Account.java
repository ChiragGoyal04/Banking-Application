package com.chirag.basicapplication.entity;

import com.chirag.basicapplication.enums.Account_Type;
import com.chirag.basicapplication.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account_no;

    private Account_Type accountType;

    private long balance;

    private Status status=Status.ACTIVE;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id") // Creates a foreign key column in this table
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transactions> transactions;

}
