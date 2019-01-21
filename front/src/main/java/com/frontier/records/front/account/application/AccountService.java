package com.frontier.records.front.account.application;

import com.frontier.records.front.account.dto.LogInRequest;
import com.frontier.records.front.account.dto.RegisterRequest;
import com.frontier.records.front.account.exception.LogInException.NoAccountException;
import com.frontier.records.front.account.exception.RegisterException.DuplicatedEmailException;
import com.frontier.records.front.account.exception.RegisterException.DuplicatedIdException;
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

    public Mono<LogInResult> logIn(LogInRequest logInRequest) {
        return Mono.just(logInRequest.getId())
                   .map(accountRepository::findAccountById)
                   .doOnNext(accountOptional -> {
                       Account account = accountOptional.orElseThrow(NoAccountException::new);
                       account.verifyPassword(logInRequest.getPassword());
                       account.verifyActivation();
                       account.verifyDeletion();
                   })
                   .map(data -> LogInResult.MATCHED);
    }

    public Mono<RegisterResult> register(RegisterRequest registerRequest) {
        verifyAccountByIdDuplication(registerRequest.getId());
        verifyAccountByEmailDuplication(registerRequest.getEmail());
        return Mono.just(registerRequest)
                   .map(request -> {
                       accountRepository.save(convertRegisterRequestToAccountIfValid(registerRequest));
                       return RegisterResult.REGISTERED;
                   });
    }

    private void verifyAccountByIdDuplication(String id) {
        if (accountRepository.findAccountById(id).isPresent()) {
            throw new DuplicatedIdException();
        }
    }

    private void verifyAccountByEmailDuplication(String email) {
        if (accountRepository.findAccountByEmail(email).isPresent()) {
            throw new DuplicatedEmailException();
        }
    }

    private Account convertRegisterRequestToAccountIfValid(RegisterRequest registerRequest) {
        Account account = Account.create(registerRequest);
        account.verifyPassword();
        account.verifyEmail();
        account.verifyName();
        return account;
    }
}
