package de.oneaxis.gradle.docker.dockerfile.command;

public class CopyCommand extends AbstractCommand{
    private final String from, origin, destination;

    public CopyCommand(final String origin, final String destination) {
        this.from = null;
        this.origin = origin;
        this.destination = destination;
    }

    public CopyCommand(final String from, final String origin, final String destination) {
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
