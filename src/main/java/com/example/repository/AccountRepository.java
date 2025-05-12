package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Account;
import java.util.*;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public Optional<Account> findAccountByUsernameAndPassword(String username, String password);
    public Optional<Account> findAccountByUsername(String username);
    public Optional<Account> findAccountByAccountId(Integer id);
}