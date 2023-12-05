import com.github.gradle.node.npm.task.NpmTask

plugins {
    id("java")
    id("com.github.node-gradle.node") version "7.0.1"
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

node {
    download.set(false)
    nodeProjectDir = file("frontend")
}

tasks.register<NpmTask>("buildFrontend") {
    dependsOn("npmInstall")
    inputs.dir("frontend")
    inputs.dir(fileTree("frontend/node_modules").exclude(".cache"))
    outputs.dir("frontend/dist")
    args.set(listOf("run", "build"))

    doLast {
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
