package de.oneaxis.gradle.docker.dockerfile.instruction;

import java.util.Arrays;
import java.util.List;

abstract class AbstractExecutableInstruction extends AbstractInstruction {
    final List<String> args;

    AbstractExecutableInstruction(final String... args) {
        this.args = Arrays.asList(args);
    }

    AbstractExecutableInstruction(final List<String> args) {
        this.args = args;
    }
}
