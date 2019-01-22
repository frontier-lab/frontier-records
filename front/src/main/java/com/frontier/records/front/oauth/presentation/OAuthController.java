package com.frontier.records.front.oauth.presentation;

import com.frontier.records.front.oauth.application.PaycoOAuthApiClient;
import com.frontier.records.front.oauth.dto.PaycoCheckTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoIssueTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoUserProfileResponse;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@SuppressWarnings("CheckStyle")
@RequestMapping("/oauth")
@Controller
@RequiredArgsConstructor
public class OAuthController {

    private final PaycoOAuthApiClient paycoOAuthApiClient;

    @GetMapping("/payco/log-in")

    public String paycoLogIn(
        @RequestParam("code") String authorizationCode,
        @RequestParam("state") String state,
        @RequestParam("token") String token,
        HttpSession session) {
        if (StringUtils.isEmpty(authorizationCode)) {
            throw new RuntimeException();
        }

        PaycoIssueTokenResponse paycoIssueTokenResponse = paycoOAuthApiClient.getPaycoIssueTokenResponse(authorizationCode);
        if (paycoIssueTokenResponse.getCode() != null) {
            throw new RuntimeException();
        }

        PaycoCheckTokenResponse paycoCheckTokenResponse = paycoOAuthApiClient.getPaycoCheckTokenResponse(paycoIssueTokenResponse.getAccessToken());
        if (!paycoCheckTokenResponse.getHeader().getSuccessful()) {
            throw new RuntimeException();
        }

        PaycoUserProfileResponse paycoUserProfileResponse = paycoOAuthApiClient.getPaycoUserProfile(paycoCheckTokenResponse.getIdNo(), paycoIssueTokenResponse.getAccessToken());
        if (!paycoUserProfileResponse.getHeader().getSuccessful()) {
            throw new RuntimeException();
        }

        session.setAttribute("LOGIN_SUCCESS", "Y");
        return "redirect:/";
    }
}
