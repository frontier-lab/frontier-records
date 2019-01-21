package com.frontier.records.front.account.dto;

import com.frontier.records.front.account.exception.RegisterException;
import com.frontier.records.front.account.model.RegisterResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterResponse {

    private static final long serialVersionUID = -7557991985341870821L;

    private final boolean successful;
    private final String message;

    public static RegisterResponse create(RegisterResult registerResult) {
        return new RegisterResponse(registerResult.isSuccessful(), registerResult.getMessage());
    }

    public static RegisterResponse createFromRegisterException(RegisterException e) {
        return new RegisterResponse(e.getResult().isSuccessful(), e.getResult().getMessage());
    }
}
