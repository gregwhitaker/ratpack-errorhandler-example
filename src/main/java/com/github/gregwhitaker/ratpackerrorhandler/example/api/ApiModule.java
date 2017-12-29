package com.github.gregwhitaker.ratpackerrorhandler.example.api;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.GetUserHandler;
import com.github.gregwhitaker.ratpackerrorhandler.example.api.user.ListUsersHandler;
import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiEndpoints.class);

        bind(ListUsersHandler.class);
        bind(GetUserHandler.class);
    }
}
