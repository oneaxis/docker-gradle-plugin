package de.oneaxis.gradle.docker.dockerfile;

import org.gradle.api.DefaultTask;

abstract class AbstractDockerTask extends DefaultTask {
    AbstractDockerTask() {
        this.setGroup("docker");
    }
}
