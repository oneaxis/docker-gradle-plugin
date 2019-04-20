package de.oneaxis.gradle.docker.dockerfile.command;

import java.io.Serializable;

public interface DockerfileCommand extends Serializable {
    String parse();
}
