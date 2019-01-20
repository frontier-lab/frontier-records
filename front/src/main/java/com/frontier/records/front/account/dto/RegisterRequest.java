package com.frontier.records.front.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String id;
    private String password;
    private String name;
    private String email;
}
