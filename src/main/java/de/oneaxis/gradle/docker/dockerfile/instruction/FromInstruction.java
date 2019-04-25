package de.oneaxis.gradle.docker.dockerfile.instruction;

public class FromInstruction extends AbstractInstruction {

    private final String baseImage, tag;

    public FromInstruction(final String baseImage) {
        this.baseImage = baseImage;
        this.tag = null;
    }

    public FromInstruction(final String baseImage, final String tag) {
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
