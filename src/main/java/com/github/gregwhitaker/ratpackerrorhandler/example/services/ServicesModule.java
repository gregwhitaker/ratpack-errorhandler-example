package com.github.gregwhitaker.ratpackerrorhandler.example.services;

import com.github.gregwhitaker.ratpackerrorhandler.example.services.user.UserService;
import com.google.inject.AbstractModule;

public class ServicesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService.class);
    }
}
