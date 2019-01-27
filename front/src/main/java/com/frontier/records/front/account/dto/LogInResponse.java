package com.frontier.records.front.account.dto;

import com.frontier.records.front.account.exception.LogInException;
import com.frontier.records.front.account.model.LogInResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogInResponse {

    private static final long serialVersionUID = -7557991985341870820L;

    private final boolean successful;
    private final String message;

    public static LogInResponse create(LogInResult logInResult) {
        return new LogInResponse(logInResult.isSuccessful(), logInResult.getMessage());
    }

    public static LogInResponse createFromLoginException(LogInException e) {
        return new LogInResponse(e.getResult().isSuccessful(), e.getResult().getMessage());
    }
}