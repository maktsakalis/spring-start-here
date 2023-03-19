package org.example;

public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public String service(String username, String password) {
        if (authenticationService.authenticate(username, password)) {
            return "home";
        } else {
            return "login";
        }
    }
}
