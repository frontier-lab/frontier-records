package com.frontier.records.front.account.dto;

import com.frontier.records.front.account.model.Account.LogInResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogInResponse {

    private static final long serialVersionUID = -7557991985341870820L;

    private final boolean successful;
    private final String message;

    public static LogInResponse create(LogInResult logInResult) {
        return new LogInResponse(logInResult.isSuccessful(),
                                 logInResult.getMessage());
    }
}
