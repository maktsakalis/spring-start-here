package com.springstarthere.loginch9.model;

import com.springstarthere.loginch9.services.LoggedUserManagementService;
import com.springstarthere.loginch9.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;

    private String password;

    private final LoggedUserManagementService loggedUserManagementService;

    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        loginCountService.incrementCount();

        boolean loginResult = false;
        if (username.equals("Makis") && password.equals("123")) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
