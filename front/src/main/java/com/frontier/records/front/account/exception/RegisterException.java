package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.model.Account;
import com.frontier.records.front.account.model.Account.RegisterResult;
import lombok.Getter;

@Getter
public class RegisterException extends AccountException {

    private Account.RegisterResult result;
    private final Object[] args;

    public RegisterException(Account.RegisterResult result) {
        this.result = result;
        this.args = null;
    }

    public RegisterException(Throwable throwable) {
        if (throwable instanceof RegisterException) {
            RegisterException e = (RegisterException) throwable;
            this.result = e.getResult();
            this.args = e.getArgs();
        } else {
            this.result = RegisterResult.UNKNOWN;
            this.args = null;
        }
    }
}
