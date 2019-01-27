package com.frontier.records.front.account.model;

import com.frontier.records.front.account.dto.RegisterRequest;
import com.frontier.records.front.account.exception.LogInException.DeactivatedAccountException;
import com.frontier.records.front.account.exception.LogInException.DeletedAccountException;
import com.frontier.records.front.account.exception.LogInException.PasswordMissMatchedException;
import com.frontier.records.front.account.exception.RegisterException.BadEmailFormatException;
import com.frontier.records.front.account.exception.RegisterException.BadPasswordFormatException;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;

@SuppressWarnings("CheckStyle")
@Getter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_seq", nullable = false, unique = true)
    @GeneratedValue
    private Long accountSeq;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false, unique = true)
    private String id;

//    @Column(name = "payco_id_no", nullable = true, unique = true)
//    private PaycoAccount paycoAccount;

    @Column(name = "deactivated", nullable = false)
    private boolean deactivated;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Column(name = "last_log_in_datetime")
    private ZonedDateTime lastLogInDateTime;

    @Column(name = "register_datetime", nullable = false)
    private ZonedDateTime registerDateTime;

    @Column(name = "modify_datetime", nullable = false)
    private ZonedDateTime modifyDateTime;


    public static Account create(@NonNull RegisterRequest registerRequest) {
        Account account = new Account();
        account.email = registerRequest.getEmail();
        account.password = registerRequest.getPassword();
        account.name = registerRequest.getName();
        account.id = registerRequest.getNickname();
        account.deleted = false;
        account.deactivated = false;
        account.registerDateTime = ZonedDateTime.now();
        account.modifyDateTime = ZonedDateTime.now();
        return account;
    }

    public static Account empty() {
        return new Account();
    }

    public boolean isEmpty() {
        return this.accountSeq == null;
    }

    public void verify() {
        verifyPassword();
        verifyEmail();
        verifyName();
    }

    public void verifyPassword(String password) {
        if (!this.password.equals(password)) {
            throw new PasswordMissMatchedException();
        }
    }

    private void verifyPassword() {
        if (this.password.length() < 8) {
            throw new BadPasswordFormatException();
        }
    }

    private void verifyEmail() {
        if (!this.email.contains("@") || !this.email.contains(".")) {
            throw new BadEmailFormatException();
        }
    }

    private void verifyName() {

    }

    public void verifyActivation() {
        if (this.deactivated) {
            throw new DeactivatedAccountException();
        }
    }

    public void verifyDeletion() {
        if (this.deleted) {
            throw new DeletedAccountException();
        }
    }
}