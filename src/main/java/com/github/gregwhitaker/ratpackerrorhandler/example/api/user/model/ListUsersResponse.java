package com.github.gregwhitaker.ratpackerrorhandler.example.api.user.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Response object returned from {@link com.github.gregwhitaker.ratpackerrorhandler.example.api.user.ListUsersHandler}.
 */
public class ListUsersResponse {
    private final List<User> users = new ArrayList<>();

    public void addUser(String username, boolean active) {
        this.users.add(new User(username, active));
    }

    public List<User> getUsers() {
        return users;
    }

    static class User {
        private String username;
        private boolean active;

        public User(String username, boolean active) {
            this.username = username;
            this.active = active;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }
}
