package com.frontier.records.front.oauth.application;

import com.frontier.records.front.oauth.dto.PaycoCheckTokenRequest;
import com.frontier.records.front.oauth.dto.PaycoCheckTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoIssueTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoUserProfileRequest;
import com.frontier.records.front.oauth.dto.PaycoUserProfileResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("CheckStyle")
@Component
public class PaycoOAuthApiClient {

    @Value("${oauth.payco.web-client-id}")
    private String webClientId;

    @Value("${oauth.payco.web-client-secret}")
    private String webClientSecret;

    @Value("${oauth.payco.issue-token-url-template}")
    private String issueTokenUrlTemplate;

    @Value("${oauth.payco.check-token-url}")
    private String checkTokenUrl;

    @Value("${oauth.payco.user-profile-by-token-url}")
    private String userProfileByTokenUrl;

    private final RestTemplate restTemplate;

    public PaycoOAuthApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PaycoIssueTokenResponse getPaycoIssueTokenResponse(String authorizationCode) {
        return restTemplate.getForObject(
            issueTokenUrlTemplate.replace("{clientId}", webClientId)
                                 .replace("{clientSecret}", webClientSecret)
                                 .replace("{authorizationCode}", authorizationCode),
            PaycoIssueTokenResponse.class);
    }

    public PaycoCheckTokenResponse getPaycoCheckTokenResponse(String accessToken) {
        return restTemplate.postForObject(
            checkTokenUrl,
            new HttpEntity<>(new PaycoCheckTokenRequest(webClientId, accessToken), getHttpHeaders(accessToken)),
            PaycoCheckTokenResponse.class);
    }

    public PaycoUserProfileResponse getPaycoUserProfile(String idNo, String accessToken) {
        return restTemplate.postForObject(
            userProfileByTokenUrl,
            new HttpEntity<>(new PaycoUserProfileRequest(idNo, webClientId, accessToken), getHttpHeaders(accessToken)),
            PaycoUserProfileResponse.class);
    }

    private HttpHeaders getHttpHeaders(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpHeaders.set("client_id", webClientId);
        httpHeaders.set("access_token", accessToken);
        return httpHeaders;
    }
}
