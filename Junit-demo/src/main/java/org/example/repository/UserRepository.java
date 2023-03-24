package org.example.repository;

import org.example.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public UserRepository() {
        users.put("makis", User.createRegularUser("makis", "pass"));
        users.put("frank", User.createRegularUser("frank", "pass2"));
        users.put("suzie", User.createRegularUser("suzie", "pass3"));

        users.put("thomas", User.createAdminUser("thomas", "pass4"));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public List<User> findAll(){
        return new LinkedList<>(users.values());
    }
}
