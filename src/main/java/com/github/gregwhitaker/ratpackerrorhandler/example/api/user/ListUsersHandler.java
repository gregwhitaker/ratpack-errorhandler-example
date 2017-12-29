package com.github.gregwhitaker.ratpackerrorhandler.example.api.user;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.model.ListUsersResponse;
import com.github.gregwhitaker.ratpackerrorhandler.example.core.error.UnsupportedActiveFlagException;
import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService;
import com.google.inject.Inject;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;

/**
 * Handler responsible for retrieving all users in the system.
 */
public class ListUsersHandler implements Handler {

    @Inject
    private UserService userService;

    @Override
    public void handle(Context ctx) throws Exception {
        String activeFlag = ctx.getRequest().getQueryParams().getOrDefault("active", "true");

        if (!activeFlag.equalsIgnoreCase("true") && !activeFlag.equalsIgnoreCase("false")) {
            throw new UnsupportedActiveFlagException();
        }

        ListUsersResponse response = new ListUsersResponse();

        userService.findAll(Boolean.parseBoolean(activeFlag)).forEach(user -> response.addUser(user.getUsername(), user.isActive()));

        ctx.render(Jackson.json(response));
    }
}
