package com.springstarthere.loginch9.controllers;

import com.springstarthere.loginch9.model.LoginProcessor;
import com.springstarthere.loginch9.model.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(LoginRequest loginRequest, Model model) {

        loginProcessor.setUsername(loginRequest.getUsername());
        loginProcessor.setPassword(loginRequest.getPassword());

        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            model.addAttribute("username", loginRequest.getUsername());
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Wrong username or password!");
            return "login.html";
        }
    }
}
