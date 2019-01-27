package com.frontier.records.front.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaycoUserProfileResponse {

    @JsonProperty("memberProfile")
    private PaycoMemberProfile paycoMemberProfile;

    @JsonProperty("header")
    private PaycoCheckTokenHeader header;
}
