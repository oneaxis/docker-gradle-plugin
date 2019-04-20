package de.oneaxis.gradle.docker.dockerfile.command;

import java.util.List;
import java.util.stream.Collectors;

public class CmdCommand extends AbstractExecutableCommand {

    public CmdCommand(String... args) {
        super(args);
    }

    public CmdCommand(List<String> args) {
        super(args);
    }

    @Override
    public String parse() {
        return String.format("CMD [%s]",
                args.stream().map(arg -> String.format("\"%s\"", arg))
                        .collect(Collectors.joining(",")));
    }
}