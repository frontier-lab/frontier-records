package com.frontier.records.front.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaycoIssueTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("state")
    private String state;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("access_token_secret")
    private String accessTokenSecret;

    // onError
    @JsonProperty("error")
    private String error;

    // onError
    @JsonProperty("code")
    private Integer code;

    // onError
    @JsonProperty("error_description")
    private String errorDescription;
}
