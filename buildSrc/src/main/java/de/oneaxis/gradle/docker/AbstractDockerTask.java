package de.oneaxis.gradle.docker;

import org.gradle.api.DefaultTask;

public abstract class AbstractDockerTask extends DefaultTask {
    public AbstractDockerTask() {
        this.setGroup("docker");
    }
}
