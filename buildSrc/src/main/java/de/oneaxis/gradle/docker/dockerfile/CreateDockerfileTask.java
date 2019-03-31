package de.oneaxis.gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.AbstractDockerTask;
import org.gradle.api.tasks.TaskAction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateDockerfileTask extends AbstractDockerTask {

    private String path;
    private Dockerfile dockerfile;

    @TaskAction
    void createDockerfile() throws IOException {
        if (path == null || path.isEmpty()) throw new DockerfilePathException();
        if (dockerfile == null) throw new DockerfileInvalidException();
        Files.write(Paths.get(path + "/Dockerfile"), dockerfile.parse().getBytes());
        System.out.printf("Created Dockerfile at: %s", path);
    }

    void setPath(final String path) {
        this.path = path;
    }

    void setDockerfile(final Dockerfile dockerfile) {
        this.dockerfile = dockerfile;
    }
}
