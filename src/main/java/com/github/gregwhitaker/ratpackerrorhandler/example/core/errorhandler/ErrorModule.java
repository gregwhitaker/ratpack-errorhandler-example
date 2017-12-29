package com.github.gregwhitaker.ratpackerrorhandler.example.core.errorhandler;

import com.google.inject.AbstractModule;
import ratpack.error.ClientErrorHandler;
import ratpack.error.ServerErrorHandler;

public class ErrorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ClientErrorHandler.class).to(GlobalErrorHandler.class);
        bind(ServerErrorHandler.class).to(GlobalErrorHandler.class);
    }
}
