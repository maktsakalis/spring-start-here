package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> users= new HashMap<>();

    public UserRepository() {
        users.put("makis", new User("makis", "pass"));
        users.put("frank", new User("frank", "pass2"));
    }

    public User findByUsername(String username){
        return users.get(username);
    }
}
