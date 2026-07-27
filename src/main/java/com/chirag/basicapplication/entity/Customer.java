package com.chirag.basicapplication.entity;

import com.chirag.basicapplication.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer_no;

    private String first_name;

    private String last_name;

    private String email;

    private Long phone_no;

    private String address;

    private Status status=Status.ACTIVE;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Account> account;

}
