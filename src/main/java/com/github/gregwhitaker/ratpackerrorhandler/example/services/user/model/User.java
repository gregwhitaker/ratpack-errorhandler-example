package com.github.gregwhitaker.ratpackerrorhandler.example.services.user.model;

/**
 * User data returned from {@link com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService}
 */
public class User {
    private final String username;
    private final boolean active;

    public User(String username, boolean active) {
        this.username = username;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public boolean isActive() {
        return active;
    }
}
