package de.oneaxis.gradle.docker.dockerfile;

class DockerfilePathException extends RuntimeException {

    DockerfilePathException() {
        super("Dockerfile path has not been set! Please provide a valid file path.");
    }
}
