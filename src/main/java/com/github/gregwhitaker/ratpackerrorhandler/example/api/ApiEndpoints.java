package com.github.gregwhitaker.ratpackerrorhandler.example.api;

import ratpack.func.Action;
import ratpack.handling.Chain;

public class ApiEndpoints implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("test", ctx -> {
            throw new RuntimeException("This thing is broken");
        });
    }
}
