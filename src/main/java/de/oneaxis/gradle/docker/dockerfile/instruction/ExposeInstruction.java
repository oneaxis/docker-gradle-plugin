package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExposeInstruction extends AbstractInstruction {

    private List<Integer> ports;

    public ExposeInstruction(final List<Integer> ports) {
        this.ports = ports;
    }

    public ExposeInstruction(final int port) {
        this.ports = new ArrayList<>();
        this.ports.add(port);
    }

    public ExposeInstruction(final Integer... ports) {
        this.ports = Arrays.asList(ports);
    }

    @Override
    public String parse() {
        return String.format("EXPOSE %s",
                ports.stream().map(Objects::toString)
                        .collect(Collectors.joining(" ")));
    }
}
