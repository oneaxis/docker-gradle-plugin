package de.oneaxis.gradle.docker.dockerfile.command;

public class WorkdirCommand extends AbstractCommand {
    private final String workdir;

    public WorkdirCommand(final String workdir) {
        this.workdir = workdir;
    }

    @Override
    public String parse() {
        return String.format("WORKDIR %s ", workdir);
    }
}
