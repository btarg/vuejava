package io.github.btarg.backend;

import io.github.btarg.backend.controllers.MyController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("static", Location.CLASSPATH);

        }).start(7000);

        app.post("/api/invokeJavaFunction", MyController.invokeJavaFunction);
        app.post("/api/receiveObject", MyController.receiveObject);
    }
}
