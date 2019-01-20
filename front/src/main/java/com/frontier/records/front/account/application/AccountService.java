package com.frontier.records.front.account.application;

import com.frontier.records.front.account.dto.LogInRequest;
import com.frontier.records.front.account.dto.LogInResponse;
import com.frontier.records.front.account.dto.RegisterRequest;
import com.frontier.records.front.account.dto.RegisterResponse;
import com.frontier.records.front.account.exception.LogInException;
import com.frontier.records.front.account.exception.RegisterException;
import com.frontier.records.front.account.model.Account;
import com.frontier.records.front.account.model.Account.LogInResult;
import com.frontier.records.front.account.model.Account.RegisterResult;
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
                   .doOnNext(account -> {
                       account.verifyPassword(logInRequest.getPassword());
                       account.verifyActivation();
                       account.verifyDeletion();
                   })
                   .map(data -> LogInResponse.create(LogInResult.MATCHED))
                   .doOnError(throwable -> {
                       throw new LogInException(throwable);
                   });
    }

    public Mono<RegisterResponse> register(RegisterRequest registerRequest) {
        if (accountRepository.findAccountById(registerRequest.getId()) != null) {
            throw new RegisterException(RegisterResult.ID_DUPLICATED);
        }

        if (accountRepository.findAccountByEmail(registerRequest.getEmail()) != null) {
            throw new RegisterException(RegisterResult.EMAIL_DUPLICATED);
        }

        Account account = Account.create(registerRequest);
        account.verifyPassword();
        account.verifyEmail();
        account.verifyName();
        accountRepository.save(account);

        return Mono.just(RegisterResponse.create(RegisterResult.REGISTERED));
    }
}
