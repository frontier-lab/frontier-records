package com.frontier.records.front.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegisterResult {

    REGISTERED(true, "회원 가입 성공"),
    BAD_PASSWORD_FORMAT(false, "잘못된 비밀번호 형식"),
    BAD_NAME_FORMAT(false, "잘못된 이름 형식"),
    BAD_EMAIL_FORMAT(false, "잘못된 이메일 형식"),
    BAD_ID_FORMAT(false, "잘못된 ID 형식"),
    ID_DUPLICATED(false, "ID 중복"),
    EMAIL_DUPLICATED(false, "이메일 중복"),
    UNKNOWN(false, "알 수 없는 오류");

    private final boolean successful;
    private final String message;
}