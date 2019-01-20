package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.dto.LogInResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountException.class)
    protected LogInResponse handleNotAllowedIpException(AccountException e) {
        return LogInResponse.create(e.getResult());
    }
}
