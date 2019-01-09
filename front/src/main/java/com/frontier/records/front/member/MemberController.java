package com.frontier.records.front.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@GetMapping("/")
	public String test() {
		return "Test";
	}
}
