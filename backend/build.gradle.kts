plugins {
    id("java")
}

group = "io.github.btarg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:5.+")
    implementation("org.slf4j:slf4j-api:1.+")
    implementation("ch.qos.logback:logback-classic:1.+")
}

tasks.register("buildFrontend") {
    doLast {
        // Execute npm run build
        project.exec {
            executable ("C:/Program Files/nodejs/npm.cmd") // Specify the full path to npm
            workingDir("frontend") // Set the working directory to the frontend module
            commandLine("npm.cmd", "run", "build")
        }

        // Copy the contents of the dist directory to src/main/resources/static
        copy {
            from("frontend/dist")
            into("src/main/resources/static")
        }
    }
}

tasks.build {
    dependsOn("buildFrontend") // Make buildFrontend task a dependency of the build task
}
