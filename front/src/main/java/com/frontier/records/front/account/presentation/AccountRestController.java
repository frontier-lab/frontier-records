package com.frontier.records.front.account.presentation;

import com.frontier.records.front.account.application.AccountService;
import com.frontier.records.front.account.dto.LogInRequest;
import com.frontier.records.front.account.dto.LogInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * created by jaeeun.yoo
 * 멤버 APIs
 */
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping("/log-in")
    public Mono<LogInResponse> logIn(LogInRequest logInRequest) {
        return accountService.logIn(logInRequest);
    }

    @GetMapping("/register")
    public void register() {
        accountService.register();
    }
}