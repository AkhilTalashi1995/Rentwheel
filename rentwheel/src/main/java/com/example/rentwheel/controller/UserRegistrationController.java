package com.example.rentwheel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rentwheel.dao.UserDAO;
import com.example.rentwheel.pojo.Role;
import com.example.rentwheel.pojo.User;


@Controller
@RequestMapping("/signup")
public class UserRegistrationController {

	
	@Autowired
    private UserDAO userDAO;

    @GetMapping
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "/signup";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (userDAO.isEmailExists(user.getEmail())) {
            model.addAttribute("error", "Email already exists. Please choose a different email.");
            return "/signup";
        }

        user.setRole(Role.USER);

        userDAO.saveUser(user);

        return "redirect:/login";
    }
}
