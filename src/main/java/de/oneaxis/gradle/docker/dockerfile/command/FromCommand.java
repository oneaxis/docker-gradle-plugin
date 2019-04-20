package de.oneaxis.gradle.docker.dockerfile.command;

public class FromCommand extends AbstractCommand {

    private final String baseImage, tag;

    public FromCommand(final String baseImage) {
        this.baseImage = baseImage;
        this.tag = null;
    }

    public FromCommand(final String baseImage, final String tag) {
        this.baseImage = baseImage;
        this.tag = tag;
    }

    @Override
    public String parse() {
        return String.format("FROM %s %s",
                baseImage,
                tag != null? String.format("as %s", tag) : "");
    }
}
