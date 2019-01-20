package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.model.Account;
import com.frontier.records.front.account.model.Account.LogInResult;
import lombok.Getter;

@Getter
public class LogInException extends AccountException {

    private final Account.LogInResult result;
    private final Object[] args;

    public LogInException(Account.LogInResult result) {
        this.result = result;
        this.args = null;
    }

    public LogInException(Throwable throwable) {
        if (throwable instanceof NullPointerException) {
            this.result = LogInResult.NO_ACCOUNT;
            this.args = null;
        } else if (throwable instanceof LogInException) {
            LogInException e = (LogInException) throwable;
            this.result = e.getResult();
            this.args = e.getArgs();
        } else {
            this.result = LogInResult.UNKNOWN;
            this.args = null;
        }
    }
}
