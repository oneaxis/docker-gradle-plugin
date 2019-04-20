package de.oneaxis.gradle.docker.dockerfile.command;

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
}
