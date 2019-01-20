package com.frontier.records.front.account.model;

import com.frontier.records.front.account.dto.RegisterRequest;
import com.frontier.records.front.account.exception.LogInException;
import com.frontier.records.front.account.exception.RegisterException;
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

    @Column(name = "last_log_in_datetime")
    private ZonedDateTime lastLogInDateTime;

    @Column(name = "register_datetime", nullable = false)
    private ZonedDateTime registerDateTime;

    @Column(name = "modify_datetime", nullable = false)
    private ZonedDateTime modifyDateTime;

    @Getter
    @AllArgsConstructor
    public enum LogInResult {

        MATCHED(true, "로그인 성공"),
        NO_ACCOUNT(false, "존재하지 않는 계정"),
        PASSWORD_MISS_MATCHED(false, "잘못된 비밀번호"),
        DEACTIVATED(false, "휴면 계정"),
        DELETED(false, "삭제된 계정"),
        UNKNOWN(false, "알 수 없는 오류");

        private final boolean successful;
        private final String message;
    }

    @Getter
    @AllArgsConstructor
    public enum RegisterResult {

        REGISTERED(true, "회원 가입 성공"),
        BAD_PASSWORD_FORMAT(false, "잘못된 비밀번호 형식"),
        BAD_NAME_FORMAT(false, "잘못된 이름 형식"),
        BAD_EMAIL_FORMAT(false, "잘못된 이메일 형식"),
        BAD_ID_FORMAT(false, "잘못된 ID 형식"),
        ID_DUPLICATED(false, "ID 중복"),
        EMAIL_DUPLICATED(false, "이메일 중복"),
        UNKNOWN(false, "알 수 없는 오류");

        private final boolean successful;
        private final String message;
    }

    public static Account create(@NonNull RegisterRequest registerRequest) {
        Account account = new Account();
        account.id = registerRequest.getId();
        account.password = registerRequest.getPassword();
        account.name = registerRequest.getName();
        account.email = registerRequest.getEmail();
        account.deleted = false;
        account.deactivated = false;
        account.registerDateTime = ZonedDateTime.now();
        account.modifyDateTime = ZonedDateTime.now();
        return account;
    }

    public void verifyPassword(String password) {
        if (!this.password.equals(password)) {
            throw new LogInException(LogInResult.PASSWORD_MISS_MATCHED);
        }
    }

    public void verifyPassword() {
        if (this.password.length() < 8) {
            throw new RegisterException(RegisterResult.BAD_PASSWORD_FORMAT);
        }
    }

    public void verifyEmail() {
        if (!this.email.contains("@") && !this.email.contains(".")) {
            throw new RegisterException(RegisterResult.BAD_EMAIL_FORMAT);
        }
    }

    public void verifyName() {

    }

    public void verifyActivation() {
        if (this.deactivated) {
            throw new LogInException(LogInResult.DEACTIVATED);
        }
    }

    public void verifyDeletion() {
        if (this.deleted) {
            throw new LogInException(LogInResult.DELETED);
        }
    }

    public static Account empty() {
        return new Account();
    }

    public boolean isEmpty() {
        return this.idNo == null;
    }
}