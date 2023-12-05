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
    implementation("org.slf4j:slf4j-simple:2.+")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.+")
}

tasks.register("buildFrontend") {
    doLast {
        // Execute npm install and npm run build
        project.exec {
            workingDir("frontend")
            commandLine("C:/Program Files/nodejs/npm.cmd", "install")
            commandLine("C:/Program Files/nodejs/npm.cmd", "run", "build")
        }

        // Copy the contents of the dist directory to src/main/resources/static
        project.copy {
            from("frontend/dist")
            into("src/main/resources/static")
        }
    }
}


tasks.build {
    dependsOn("buildFrontend")
}
