package com.github.gregwhitaker.ratpackerrorhandler.example;

import com.github.gregwhitaker.ratpackerrorhandler.example.api.ApiEndpoints;
import com.github.gregwhitaker.ratpackerrorhandler.example.api.ApiModule;
import com.github.gregwhitaker.ratpackerrorhandler.example.core.errorhandler.ErrorModule;
import com.github.gregwhitaker.ratpackerrorhandler.example.services.ServicesModule;
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
                        .module(ApiModule.class)
                        .module(ServicesModule.class)))
                .handlers(c -> c
                        .insert(ApiEndpoints.class)
                        .files(f -> f.dir("public").indexFiles("index.html")))
        );
    }
}
