package com.frontier.records.front.main.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class MainController {

    @GetMapping("**")
    public String main(@RequestParam(value="mobile", required = false) String mobile) {
        return StringUtils.isEmpty(mobile) ? "index" : "index-mobile";
    }
    
}
