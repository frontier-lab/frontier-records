package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.model.Account;
import com.frontier.records.front.account.model.Account.LogInResult;
import lombok.Getter;

@Getter
public class AccountException extends RuntimeException {


    private static final long serialVersionUID = 4394641281005595522L;
    private Account.LogInResult result;
    private final Object[] args;

    public AccountException(Account.LogInResult result) {
        this.result = result;
        this.args = null;
    }

    public AccountException(Throwable throwable) {
        if (throwable instanceof AccountException) {
            AccountException e = (AccountException) throwable;
            this.result = e.getResult();
            this.args = e.getArgs();
        } else {
            this.result = LogInResult.NO_ACCOUNT;
            this.args = null;
        }
    }
}
