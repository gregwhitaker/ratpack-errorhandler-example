package com.github.gregwhitaker.ratpackerrorhandler.example.api.user;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.model.GetUserResponse;
import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService;
import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.model.User;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

/**
 * Handler responsible for retrieving user data by the username.
 */
public class GetUserHandler implements Handler {

    @Inject
    private UserService userService;

    @Override
    public void handle(Context ctx) throws Exception {
        User user = userService.findOne(ctx.getAllPathTokens().get("username"));

        GetUserResponse response = new GetUserResponse();
        response.setUsername(user.getUsername());
        response.setActive(user.isActive());

        ctx.render(Jackson.json(response));
    }
}
