package com.frontier.records.front.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaycoCheckTokenRequest {

    @JsonProperty("client_id")
    private final String clientId;

    @JsonProperty("access_token")
    private final String accessToken;
}
