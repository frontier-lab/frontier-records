package com.frontier.records.front.oauth.interceptor;

import com.frontier.records.front.account.dto.LogInSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OAuthCheckInterceptor extends HandlerInterceptorAdapter {

    private static final String LOG_IN_SESSION_KEY = "LOG_IN_SESSION";

    // FIXME 세션 관리 서버 생기면 삭제
    private static List<String> DEVELOPER_ID_NO_LIST = Arrays.asList(
        "0fb0e0b0-b734-11e4-8528-000000003e44",     // 귀영
        "1de09dc0-c34c-11e7-be2e-005056ac60a7");    // 재은

    @Value("${redirect-urls.recommend}")
    private String homeUrl;

    @Value("${redirect-urls.log-in}")
    private String logInUrl;

    @Value("${redirect-urls.sign-up}")
    private String signUpUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        if (request.getServletPath().contains("/oauth/payco/log-in")) {
            return true;
        }

        LogInSession logInSession = (LogInSession) request.getSession().getAttribute(LOG_IN_SESSION_KEY);
        if (logInSession != null) {
            if (DEVELOPER_ID_NO_LIST.contains(logInSession.getPaycoIdNo())) {
                response.sendRedirect(homeUrl);
                return false;
            } else {
                response.sendRedirect(signUpUrl);
                return false;
            }
        }

        return true;
    }
}