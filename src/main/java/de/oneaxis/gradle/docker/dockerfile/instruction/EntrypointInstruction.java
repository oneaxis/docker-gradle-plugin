package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.util.List;
import java.util.stream.Collectors;

public class EntrypointInstruction extends AbstractExecutableInstruction {

    public EntrypointInstruction(String... args) {
        super(args);
    }

    public EntrypointInstruction(List<String> args) {
        super(args);
    }

    public EntrypointInstruction(String arg) {
        super(arg);
    }

    @Override
    public String parse() {
        return String.format("ENTRYPOINT [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}
