package gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.dockerfile.CreateDockerfileTask;
import de.oneaxis.gradle.docker.dockerfile.DefaultDockerfile;
import de.oneaxis.gradle.docker.dockerfile.MultistageDockerfile;
import de.oneaxis.gradle.docker.dockerfile.command.*;
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
    private final static List<DockerfileCommand> commands = List.of(
            new FromCommand("gradle:5.3.0-jdk11-slim"),
            new UserCommand("root"),
            new WorkdirCommand("/builder"),
            new CopyCommand(".", "."),
            new RunCommand("java/gradle", "build")
    );

    @AfterClass
    public static void onStop() {

    }

    @Test
    public void testGiven_ConfigurationAttributes_Then_WriteDefaultDockerfile() throws IOException {
        final CreateDockerfileTask createDockerfileTask = new CreateDockerfileTask();
        createDockerfileTask.setDockerfile(new DefaultDockerfile(commands));
        createDockerfileTask.setFilePath(filePath);
        createDockerfileTask.createDockerfile();
    }

    @Test
    public void Given_ConfigurationAttributes_Then_WriteMultistageDockerfile() throws IOException {
        final CreateDockerfileTask createDockerfileTask = new CreateDockerfileTask();
        createDockerfileTask.setDockerfile(new MultistageDockerfile(
                new DefaultDockerfile(commands),
                new DefaultDockerfile(commands)
        ));
        createDockerfileTask.setFilePath(filePath);
        createDockerfileTask.createDockerfile();
    }
}
