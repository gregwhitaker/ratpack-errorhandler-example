package com.github.gregwhitaker.ratpackerrorhandler.example.api;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.GetUserHandler;
import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.ListUsersHandler;
import ratpack.func.Action;
import ratpack.handling.Chain;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("users", ListUsersHandler.class);
        chain.get("users/:id", GetUserHandler.class);
    }
}
