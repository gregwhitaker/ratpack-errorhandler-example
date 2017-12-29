package com.github.gregwhitaker.ratpackerrorhandler.example.api.user.model;

public class GetUserResponse {
    private String username;
    private boolean active;

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
