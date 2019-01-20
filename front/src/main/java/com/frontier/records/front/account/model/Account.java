package com.frontier.records.front.account.model;

import com.frontier.records.front.account.exception.AccountException;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@SuppressWarnings("CheckStyle")
@Getter
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id_no", nullable = false, unique = true)
    @GeneratedValue
    private Long idNo;

    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "deactivated", nullable = false)
    private boolean deactivated;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Column(name = "register_datetime", nullable = false)
    private ZonedDateTime registerDatetime;

    @Column(name = "modify_datetime", nullable = false)
    private ZonedDateTime modifyDatetime;

    public void verify(String password) {
        if (!this.password.equals(password)) {
            throw new AccountException(LogInResult.PASSWORD_MISS_MATCHED);
        }

        if (this.deactivated) {
            throw new AccountException(LogInResult.DEACTIVATED);
        }

        if (this.deleted) {
            throw new AccountException(LogInResult.DELETED);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Param {

        private String id;
        private String password;
        private String name;
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public enum LogInResult {

        MATCHED(true, "로그인 성공"),
        NO_ACCOUNT(false, "존재하지 않는 계정"),
        PASSWORD_MISS_MATCHED(false, "잘못된 비밀번호"),
        DEACTIVATED(false, "휴면 계정"),
        DELETED(false, "삭제된 계정");

        private final boolean successful;
        private final String message;
    }

    public static Account create(@NonNull Account.Param param) {
        Account account = new Account();
        account.id = param.getId();
        account.password = param.getPassword();
        account.name = param.getName();
        account.email = param.getEmail();
        account.deleted = false;
        account.deactivated = false;
        account.registerDatetime = ZonedDateTime.now();
        account.modifyDatetime = ZonedDateTime.now();
        return account;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}