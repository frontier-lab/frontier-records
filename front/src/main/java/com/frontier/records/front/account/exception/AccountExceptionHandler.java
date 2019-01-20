package com.frontier.records.front.account.exception;

import com.frontier.records.front.account.dto.LogInResponse;
import com.frontier.records.front.account.dto.RegisterResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LogInException.class)
    protected LogInResponse handleLogInException(LogInException e) {
        return LogInResponse.create(e.getResult());
    }

    @ExceptionHandler(RegisterException.class)
    protected RegisterResponse handleLogInException(RegisterException e) {
        return RegisterResponse.create(e.getResult());
    }
}
