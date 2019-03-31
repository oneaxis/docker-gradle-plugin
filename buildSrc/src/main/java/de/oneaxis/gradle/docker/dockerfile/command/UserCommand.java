package de.oneaxis.gradle.docker.dockerfile.command;

public class UserCommand extends AbstractCommand {
    private final String user;

    public UserCommand(final String user) {
        this.user = user;
    }

    @Override
    public String parse() {
        return String.format("USER %s ", user);
    }
}
