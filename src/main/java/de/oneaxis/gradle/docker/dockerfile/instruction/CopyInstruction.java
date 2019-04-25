package de.oneaxis.gradle.docker.dockerfile.instruction;

public class CopyInstruction extends AbstractInstruction {
    private final String from, origin, destination;

    public CopyInstruction(final String origin, final String destination) {
        this.from = null;
        this.origin = origin;
        this.destination = destination;
    }

    public CopyInstruction(final String from, final String origin, final String destination) {
        this.from = from;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public String parse() {
        return String.format("COPY %s %s %s",
                from != null? String.format("--from=%s", from) : "",
                origin,
                destination);
    }
}
