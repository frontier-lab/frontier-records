package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.model.Account.LogInResult;
import lombok.Getter;

@Getter
public class LogInException extends AccountException {

    private LogInResult result;
    private Object[] args;

    LogInException(LogInResult result, Object[] args) {
        this.result = result;
        this.args = args;
    }

    public static class NoAccountException extends LogInException {

        public NoAccountException() {
            super(LogInResult.NO_ACCOUNT, null);
        }
    }

    public static class PasswordMissMatchedException extends LogInException {

        public PasswordMissMatchedException() {
            super(LogInResult.PASSWORD_MISS_MATCHED, null);
        }
    }

    public static class DeactivatedAccountException extends LogInException {

        public DeactivatedAccountException() {
            super(LogInResult.DEACTIVATED, null);
        }
    }

    public static class DeletedAccountException extends LogInException {

        public DeletedAccountException() {
            super(LogInResult.DELETED, null);
        }
    }
}
