package com.example.rentwheel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserHomeController {
	
	@GetMapping("/dashboard")
    public String showUserHome() {
        return "user-home";
    }

	
}

