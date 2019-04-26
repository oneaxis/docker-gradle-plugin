package de.oneaxis.gradle.docker;

import de.oneaxis.gradle.docker.dockerfile.CreateDockerfileTask;
import de.oneaxis.gradle.docker.dockerfile.DefaultDockerfile;
import de.oneaxis.gradle.docker.dockerfile.MultistageDockerfile;
import de.oneaxis.gradle.docker.dockerfile.instruction.*;
import org.gradle.internal.impldep.org.junit.AfterClass;
import org.gradle.internal.impldep.org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class DockerfileTaskTest {

    private File projectDir = new File(System.getProperty("project.rootDir") + "/buildSrc/src/test/");

    //Preconditions
    private final static File filePath = new File("./" + UUID.randomUUID().toString());
    private final static List<DockerfileInstruction> instructions = List.of(
            new FromInstruction("gradle:5.3.0-jdk11-slim"),
            new UserInstruction("root"),
            new WorkdirInstruction("/builder"),
            new CopyInstruction(".", "."),
            new RunInstruction("java/gradle", "build")
    );

    @AfterClass
    public static void onStop() {

    }

    @Test
    public void Given_ConfigurationAttributes_Then_WriteDefaultDockerfile() throws IOException {
        final CreateDockerfileTask createDockerfileTask = new CreateDockerfileTask();
        createDockerfileTask.setDockerfile(new DefaultDockerfile());
        createDockerfileTask.setFilePath(filePath);
        createDockerfileTask.createDockerfile();
    }

    @Test
    public void Given_ConfigurationAttributes_Then_WriteMultistageDockerfile() throws IOException {
        final CreateDockerfileTask createDockerfileTask = new CreateDockerfileTask();
        createDockerfileTask.setDockerfile(new MultistageDockerfile(
                new DefaultDockerfile(instructions),
                new DefaultDockerfile(instructions)
        ));
        createDockerfileTask.setFilePath(filePath);
        createDockerfileTask.createDockerfile();
    }
}
