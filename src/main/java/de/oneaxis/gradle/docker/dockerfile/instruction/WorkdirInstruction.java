package de.oneaxis.gradle.docker.dockerfile.instruction;

public class WorkdirInstruction extends AbstractInstruction {
    private final String workdir;

    public WorkdirInstruction(final String workdir) {
        this.workdir = workdir;
    }

    @Override
    public String parse() {
        return String.format("WORKDIR %s ", workdir);
    }
}
