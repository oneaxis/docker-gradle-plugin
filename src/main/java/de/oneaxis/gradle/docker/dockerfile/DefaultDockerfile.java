package de.oneaxis.gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.dockerfile.command.DockerfileCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDockerfile implements Dockerfile {
    private final List<DockerfileCommand> commands;

    public DefaultDockerfile(final DockerfileCommand... commands) {
        this.commands = Arrays.asList(commands);
    }

    public DefaultDockerfile(final List<DockerfileCommand> commands) {
        this.commands = commands;
    }

    public DefaultDockerfile() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(final DockerfileCommand command) {
        this.commands.add(command);
    }

    @Override
    public String parse() {
        return commands.stream()
                .map(DockerfileCommand::parse)
                .collect(Collectors.joining("\n"));
    }
}
