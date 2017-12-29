package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

/**
 * Exception thrown when a user cannot be found.
 */
public class NoSuchUserException extends BaseException {
    private final String username;

    public NoSuchUserException(String username) {
        super(404, "5678", "NoSuchUserException", String.format("User '%s' does not exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
