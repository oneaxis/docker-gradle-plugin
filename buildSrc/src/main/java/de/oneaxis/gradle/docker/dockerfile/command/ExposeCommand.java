package de.oneaxis.gradle.docker.dockerfile.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ExposeCommand extends AbstractCommand {

    private List<Integer> ports;

    public ExposeCommand(final List<Integer> ports) {
        this.ports = ports;
    }

    public ExposeCommand(final int port) {
        this.ports = new ArrayList<>();
        this.ports.add(port);
    }

    public ExposeCommand(final Integer... ports) {
        this.ports = Arrays.asList(ports);
    }

    @Override
    public String parse() {
        return String.format("EXPOSE %s",
                ports.stream().map(Objects::toString)
                        .collect(Collectors.joining(" ")));
    }
}
