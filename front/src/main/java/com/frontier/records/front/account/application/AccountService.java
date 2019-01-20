package com.frontier.records.front.account.application;

import com.frontier.records.front.account.dto.LogInRequest;
import com.frontier.records.front.account.dto.LogInResponse;
import com.frontier.records.front.account.exception.AccountException;
import com.frontier.records.front.account.model.Account;
import com.frontier.records.front.account.model.Account.LogInResult;
import com.frontier.records.front.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Mono<LogInResponse> logIn(LogInRequest logInRequest) {
        return Mono.just(logInRequest.getId())
                   .map(accountRepository::findAccountById)
                   .doOnNext(account -> account.verify(logInRequest.getPassword()))
                   .map(data -> LogInResponse.create(LogInResult.MATCHED))
                   .doOnError(AccountException::new);
    }

    // TODO: 삭제 예정
    public void register() {
        accountRepository.save(
            Account.create(new Account.Param(
                "a",
                "1",
                "유재은",
                "frontiersofme@gmail.com"
            ))
        );
    }
}
