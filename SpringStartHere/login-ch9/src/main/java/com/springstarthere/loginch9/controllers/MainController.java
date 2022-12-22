package com.springstarthere.loginch9.controllers;

import com.springstarthere.loginch9.services.LoggedUserManagementService;
import com.springstarthere.loginch9.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model) {

        if (logout != null) {
            loggedUserManagementService.setUsername(null);
            loginCountService.setCount(0);
        }

        if (loggedUserManagementService.getUsername() == null) {
            return "redirect:/";
        }
        model.addAttribute("username", loggedUserManagementService.getUsername());
        model.addAttribute("count", loginCountService.getCount());
        return "main.html";
    }
}
