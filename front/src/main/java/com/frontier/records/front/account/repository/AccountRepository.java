package com.frontier.records.front.account.repository;

import com.frontier.records.front.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findAccountByEmail(String email);
}
