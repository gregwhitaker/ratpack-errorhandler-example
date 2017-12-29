package com.github.gregwhitaker.ratpackerrorhandler.example.api;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiEndpoints.class);
    }
}
