package com.frontier.records.front.account.repository;

import com.frontier.records.front.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, String> {

    Account findAccountById(String id);

    Account findAccountByEmail(String email);
}
