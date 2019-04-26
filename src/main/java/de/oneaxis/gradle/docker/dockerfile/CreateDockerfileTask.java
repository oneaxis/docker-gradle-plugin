package de.oneaxis.gradle.docker.dockerfile;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateDockerfileTask extends AbstractDockerTask implements DockerfileGradleGlue {

    private File filePath;
    private Dockerfile dockerfile;

    @TaskAction
    public void createDockerfile() throws IOException {
        if (dockerfile == null) throw new DockerfileInvalidException();
        Files.write(Paths.get(filePath.toURI()), dockerfile.parse().getBytes());
        System.out.printf("Created Dockerfile at: %s", filePath);
    }

    @OutputFile
    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(final File filePath) {
        this.filePath = filePath;
    }

    @Input
    public Dockerfile getDockerfile() {
        return dockerfile;
    }

    public void setDockerfile(final Dockerfile dockerfile) {
        this.dockerfile = dockerfile;
    }
}
