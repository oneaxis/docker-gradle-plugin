package de.oneaxis.gradle.docker.dockerfile.command;

import java.util.List;
import java.util.stream.Collectors;

public class RunCommand extends AbstractExecutableCommand {

    public RunCommand(String... args) {
        super(args);
    }

    public RunCommand(List<String> args) {
        super(args);
    }

    public RunCommand(String arg) {
        super(arg);
    }

    @Override
    public String parse() {
        return String.format("RUN [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}
