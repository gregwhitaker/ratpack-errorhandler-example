package com.github.gregwhitaker.ratpackerrorhandler.example.api.user;

import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class ListUsersHandler implements Handler {

    @Inject
    private UserService userService;

    @Override
    public void handle(Context ctx) throws Exception {

    }
}
