package com.frontier.records.front.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaycoCheckTokenResponse {

    @JsonProperty("header")
    private PaycoCheckTokenHeader header;

    @JsonProperty("idNo")
    private String idNo;
}
