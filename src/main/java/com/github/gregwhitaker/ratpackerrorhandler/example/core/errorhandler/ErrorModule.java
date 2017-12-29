package com.github.gregwhitaker.ratpackerrorhandler.example.core.errorhandler;

import com.google.inject.AbstractModule;
import ratpack.error.ClientErrorHandler;
import ratpack.error.ServerErrorHandler;

/**
 * Guice module responsible for adding error handling capabilities.
 */
public class ErrorModule extends AbstractModule {

    @Override
    protected void configure() {
        // Wire the ClientErrorHandler and ServerErrorHandler interfaces to your GlobalErrorHandler instance
        bind(ClientErrorHandler.class).to(GlobalErrorHandler.class);
        bind(ServerErrorHandler.class).to(GlobalErrorHandler.class);
    }
}
