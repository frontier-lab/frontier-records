package com.frontier.records.front.account.repository;

import com.frontier.records.front.account.model.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findAccountById(String id);

    Optional<Account> findAccountByEmail(String email);
}
