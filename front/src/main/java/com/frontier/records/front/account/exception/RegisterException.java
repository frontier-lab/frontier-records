package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.model.Account.RegisterResult;
import lombok.Getter;

@Getter
public class RegisterException extends AccountException {

    private RegisterResult result;
    private Object[] args;

    RegisterException(RegisterResult result, Object[] args) {
        this.result = result;
        this.args = null;
    }

    public static class DuplicatedEmailException extends RegisterException {

        public DuplicatedEmailException() {
            super(RegisterResult.EMAIL_DUPLICATED, null);
        }
    }

    public static class DuplicatedIdException extends RegisterException {

        public DuplicatedIdException() {
            super(RegisterResult.ID_DUPLICATED, null);
        }
    }

    public static class BadPasswordFormatException extends RegisterException {

        public BadPasswordFormatException() {
            super(RegisterResult.BAD_PASSWORD_FORMAT, null);
        }
    }

    public static class BadEmailFormatException extends RegisterException {

        public BadEmailFormatException() {
            super(RegisterResult.BAD_EMAIL_FORMAT, null);
        }
    }

    public static class BadNameFormatException extends RegisterException {

        public BadNameFormatException() {
            super(RegisterResult.BAD_NAME_FORMAT, null);
        }
    }

    public static class UnknownException extends RegisterException {

        public UnknownException() {
            super(RegisterResult.UNKNOWN, null);
        }
    }
}