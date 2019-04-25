package de.oneaxis.gradle.docker.dockerfile.instruction;

public class UserInstruction extends AbstractInstruction {
    private final String user;

    public UserInstruction(final String user) {
        this.user = user;
    }

    @Override
    public String parse() {
        return String.format("USER %s ", user);
    }
}
