# vuejava
[VueJS](https://vuejs.org/) with [Vite](https://vitejs.dev/) + [Javalin](https://javalin.io/) + Java 21 + Gradle Kotlin

This example app has a text box input with a button which will send the input back to [a Java function](https://github.com/btarg/vuejava/blob/main/backend/src/main/java/io/github/btarg/backend/controllers/MyController.java#L7) which will then echo the response back to the [Vue.js portion of the app](https://github.com/btarg/vuejava/blob/main/backend/frontend/src/App.vue).
# Build and run
From the `backend` directory, run
```
./gradlew build
```
Your jar will be in `build/libs`
