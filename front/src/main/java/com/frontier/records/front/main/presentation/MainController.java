package com.frontier.records.front.main.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("**")
    public String main() {
        return "index";
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }


}
