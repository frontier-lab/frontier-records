package com.frontier.records.front.oauth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaycoMemberProfile {

    @JsonProperty("sexCode")
    private String sexCode;

    @JsonProperty("idNo")
    private String idNo;

    @JsonProperty("birthdayMMDD")
    private String birthdayMMDD;

    @JsonProperty("maskingMobileId")
    private String maskingMobileId;

    @JsonProperty("maskingId")
    private String maskingId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("mobileId")
    private String mobileId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ageGroup")
    private String ageGroup;
}