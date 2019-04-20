package de.oneaxis.gradle.docker;

import de.oneaxis.gradle.docker.dockerfile.CreateDockerfileTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DockerPlugin implements Plugin<Project> {

    @Override
    public void apply(final Project project) {
        project.getTasks().create("createDockerfile", CreateDockerfileTask.class);
    }
}