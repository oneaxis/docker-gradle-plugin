package de.oneaxis.gradle.docker.dockerfile;

import java.io.Serializable;

public interface Dockerfile extends Serializable {
    String parse();
}
