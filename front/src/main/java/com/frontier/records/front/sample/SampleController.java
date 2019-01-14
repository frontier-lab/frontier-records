package com.frontier.records.front.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("CheckStyle")
@Controller
public class SampleController {

    @GetMapping("/")
    public String sample(Model model) {
        model.addAttribute("eng", "English");
        model.addAttribute("name", "한글한글");
        return "sample";
    }
}
