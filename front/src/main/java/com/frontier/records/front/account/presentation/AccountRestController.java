package com.frontier.records.front.account.presentation;

import com.frontier.records.front.account.application.AccountService;
import com.frontier.records.front.account.dto.LogInRequest;
import com.frontier.records.front.account.dto.LogInResponse;
import com.frontier.records.front.account.dto.RegisterRequest;
import com.frontier.records.front.account.dto.RegisterResponse;
import com.frontier.records.front.account.exception.LogInException;
import com.frontier.records.front.account.exception.RegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * created by jaeeun.yoo
 * 멤버 APIs
 */
@SuppressWarnings("CheckStyle")
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping("/log-in")
    public Mono<LogInResponse> logIn(LogInRequest logInRequest) {
        return accountService.logIn(logInRequest)
                             .map(LogInResponse::create)
                             .onErrorResume(LogInException.class, e -> Mono.just(LogInResponse.createFromLoginException(e)));
    }

    @GetMapping("/register")
    public Mono<RegisterResponse> register(RegisterRequest registerRequest) {
        return accountService.register(registerRequest)
                             .map(RegisterResponse::create)
                             .onErrorResume(RegisterException.class, e -> Mono.just(RegisterResponse.createFromRegisterException(e)));
    }
}