package com.frontier.records.front.oauth.presentation;

import com.frontier.records.front.account.dto.LogInSession;
import com.frontier.records.front.oauth.application.PaycoOAuthApiClient;
import com.frontier.records.front.oauth.dto.PaycoCheckTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoIssueTokenResponse;
import com.frontier.records.front.oauth.dto.PaycoUserProfileResponse;
import java.util.Arrays;
import java.util.List;
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

    private static final String LOG_IN_SESSION_KEY = "LOG_IN_SESSION";

    // FIXME 세션 관리 서버 생기면 삭제
    private static List<String> DEVELOPER_ID_NO_LIST = Arrays.asList(
        "0fb0e0b0-b734-11e4-8528-000000003e44",     // 귀영
        "1de09dc0-c34c-11e7-be2e-005056ac60a7");    // 재은

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

        if (DEVELOPER_ID_NO_LIST.contains(paycoCheckTokenResponse.getIdNo())) {
            LogInSession neLogInSession = new LogInSession();
            neLogInSession.setPaycoIdNo(paycoCheckTokenResponse.getIdNo());
            session.setAttribute(LOG_IN_SESSION_KEY, neLogInSession);
            return "redirect:/";
        }

        return "redirect:/sign-up";
    }
}
