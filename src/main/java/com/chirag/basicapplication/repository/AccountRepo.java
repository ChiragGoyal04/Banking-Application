package com.chirag.basicapplication.repository;

import com.chirag.basicapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
