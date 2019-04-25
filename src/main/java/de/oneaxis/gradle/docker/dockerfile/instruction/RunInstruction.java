package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.util.List;
import java.util.stream.Collectors;

public class RunInstruction extends AbstractExecutableInstruction {

    public RunInstruction(String... args) {
        super(args);
    }

    public RunInstruction(List<String> args) {
        super(args);
    }

    public RunInstruction(String arg) {
        super(arg);
    }

    @Override
    public String parse() {
        return String.format("RUN [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}
