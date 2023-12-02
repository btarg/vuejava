package io.github.btarg.backend.controllers;

import io.javalin.http.Handler;

public class MyController {

    public static Handler invokeJavaFunction = ctx -> {
        String argument = ctx.body();
        // Your Java function logic with the provided argument
        ctx.result("Java function invoked with argument: " + argument);
    };
}