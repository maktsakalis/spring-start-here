package org.example.service;

import org.example.User;
import org.example.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserLookupService {

    private final UserRepository userRepository;

    public UserLookupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<User> getRegularUsers() {
        return getUsersByUserType(User.UserType.REGULAR_USER);
    }

    public Set<User> getAdminUsers() {
        return getUsersByUserType(User.UserType.ADMIN_USER);
    }

    private Set<User> getUsersByUserType(User.UserType userType) {
        return userRepository.findAll().stream().filter(u -> u.getUserType().equals(userType)).collect(Collectors.toSet());
    }
}
