package de.oneaxis.gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.dockerfile.instruction.DockerfileInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDockerfile implements Dockerfile {
    private final List<DockerfileInstruction> instructions;

    DefaultDockerfile(final DockerfileInstruction... instructions) {
        this.instructions = Arrays.asList(instructions);
    }

    public DefaultDockerfile(final List<DockerfileInstruction> instructions) {
        this.instructions = instructions;
    }

    public DefaultDockerfile() {
        this.instructions = new ArrayList<>();
    }

    @Override
    public String parse() {
        return instructions.stream()
                .map(DockerfileInstruction::parse)
                .collect(Collectors.joining("\n"));
    }
}
