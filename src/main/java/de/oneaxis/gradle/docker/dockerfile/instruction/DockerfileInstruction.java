package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.io.Serializable;

public interface DockerfileInstruction extends Serializable {
    String parse();
}
