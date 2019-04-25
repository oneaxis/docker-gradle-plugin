package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.util.List;
import java.util.stream.Collectors;

public class CmdInstruction extends AbstractExecutableInstruction {

    public CmdInstruction(String... args) {
        super(args);
    }

    public CmdInstruction(List<String> args) {
        super(args);
    }

    @Override
    public String parse() {
        return String.format("CMD [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}