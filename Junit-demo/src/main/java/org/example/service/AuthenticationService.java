package org.example.service;

import org.example.User;
import org.example.repository.UserRepository;

public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user.getPassword().equals(password);
    }
}
