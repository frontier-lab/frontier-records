package com.frontier.records.front.main.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class MainController {

    @GetMapping("**")
    public String main(@RequestParam(value="pc", required = false) String pc) {
        return StringUtils.isEmpty(pc) ? "index-mobile" : "index";
    }
    
}
