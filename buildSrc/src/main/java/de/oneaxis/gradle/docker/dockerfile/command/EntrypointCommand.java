package de.oneaxis.gradle.docker.dockerfile.command;

import java.util.List;
import java.util.stream.Collectors;

public class EntrypointCommand extends AbstractExecutableCommand {

    public EntrypointCommand(String... args) {
        super(args);
    }

    public EntrypointCommand(List<String> args) {
        super(args);
    }

    public EntrypointCommand(String arg) {
        super(arg);
    }

    @Override
    public String parse() {
        return String.format("ENTRYPOINT [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}
