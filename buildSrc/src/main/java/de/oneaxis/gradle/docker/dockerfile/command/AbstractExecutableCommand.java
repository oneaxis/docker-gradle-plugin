package de.oneaxis.gradle.docker.dockerfile.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class AbstractExecutableCommand extends AbstractCommand {
    final List<String> args;

    AbstractExecutableCommand(final String... args) {
        this.args = Arrays.asList(args);
    }

    AbstractExecutableCommand(final List<String> args) {
        this.args = args;
    }

    AbstractExecutableCommand(final String arg) {
        this.args = new ArrayList<>();
        this.args.add(arg);
    }
}
