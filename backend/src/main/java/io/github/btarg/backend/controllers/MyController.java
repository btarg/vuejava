package io.github.btarg.backend.controllers;

import io.github.btarg.backend.MyCustomObject;
import io.javalin.http.Handler;

public class MyController {

    public static Handler invokeJavaFunction = ctx -> {
        String argument = ctx.body();
        ctx.result("Response from Java: " + argument);
    };
    public static Handler receiveObject = ctx -> {
        try {
            MyCustomObject myCustomObject = ctx.bodyAsClass(MyCustomObject.class);
            ctx.result("Test String is: " + myCustomObject.testString + " Test Integer is: " + myCustomObject.testInt);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            ctx.status(500).json("Internal Server Error");
        }
    };

}