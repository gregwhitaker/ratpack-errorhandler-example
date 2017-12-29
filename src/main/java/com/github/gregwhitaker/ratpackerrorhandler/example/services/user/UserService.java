package com.github.gregwhitaker.ratpackerrorhandler.example.services.user;

import com.github.gregwhitaker.ratpackerrorhandler.example.core.error.NoSuchUserException;
import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.model.User;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class UserService {
    private static final Map<String, User> USERS = new HashMap<>();

    public UserService() {
        USERS.put("bob", new User("bob", true));
        USERS.put("alice", new User("alice", true));
        USERS.put("sally", new User("sally", false));
        USERS.put("john", new User("john", true));
    }

    public List<User> findAll(boolean active) {
        List<User> userList = new ArrayList<>();

        USERS.forEach((s, user) -> {
            if (user.isActive() == active) {
                userList.add(user);
            }
        });

        return Collections.unmodifiableList(userList);
    }

    public User findOne(String username) {
        User user = USERS.get(username);

        if (user == null) {
            throw new NoSuchUserException(username);
        }

        return user;
    }
}
