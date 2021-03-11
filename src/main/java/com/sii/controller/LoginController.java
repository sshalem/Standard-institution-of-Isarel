package com.sii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/student_login")
	public String loginPage() {
		return "mylogin.html";
	}

}
