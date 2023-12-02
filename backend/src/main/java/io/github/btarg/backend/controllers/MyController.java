package io.github.btarg.backend.controllers;

import io.javalin.http.Handler;

public class MyController {

    public static Handler invokeJavaFunction = ctx -> {
        String argument = ctx.body();
        ctx.result("Response from Java: " + argument);
    };
}