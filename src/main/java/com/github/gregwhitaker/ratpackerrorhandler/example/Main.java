package com.github.gregwhitaker.ratpackerrorhandler.example;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.ApiEndpoints;
import com.github.gregwhitaker.ratpackerrorhandler.example.api.ApiModule;
import com.github.gregwhitaker.ratpackerrorhandler.example.core.error.ErrorModule;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Starts the ratpack-errorhandler-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .baseDir(BaseDir.find()).build())
                .registry(Guice.registry(b -> b
                        .module(ErrorModule.class)
                        .module(ApiModule.class)))
                .handlers(c -> c
                        .insert(ApiEndpoints.class)
                        .files(f -> f.indexFiles("index.html")))
        );
    }
}
