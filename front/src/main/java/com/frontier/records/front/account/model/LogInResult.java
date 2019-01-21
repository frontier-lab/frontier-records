package com.frontier.records.front.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogInResult {

    MATCHED(true, "로그인 성공"),
    NO_ACCOUNT(false, "존재하지 않는 계정"),
    PASSWORD_MISS_MATCHED(false, "잘못된 비밀번호"),
    DEACTIVATED(false, "휴면 계정"),
    DELETED(false, "삭제된 계정"),
    UNKNOWN(false, "알 수 없는 오류");

    private final boolean successful;
    private final String message;
}