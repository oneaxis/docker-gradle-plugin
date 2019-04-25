package de.oneaxis.gradle.docker.dockerfile;

class DockerfileInvalidException extends RuntimeException {

    DockerfileInvalidException() {
        super("Dockerfile invalid or no instruction found!");
    }
}
