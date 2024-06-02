

package com.example.rentwheel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rentwheel.dao.UserDAO;
import com.example.rentwheel.pojo.Role;
import com.example.rentwheel.pojo.User;
import com.example.rentwheel.util.PasswordUtility;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	@Autowired
    private UserDAO userDAO;

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpSession session) {
        model.addAttribute("user", new User());
        
        model.addAttribute("sessionId", session.getId());

        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userDAO.getUserByEmail(email);

        if (user != null && PasswordUtility.checkPassword(user, password)) {
            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin/home";
            } else {
                return "redirect:/user/home";
            }
        } else {
        	model.addAttribute("error", "Invalid email or password");
            model.addAttribute("user", new User());
            

            return "login";
        }
    }
    
    

}
