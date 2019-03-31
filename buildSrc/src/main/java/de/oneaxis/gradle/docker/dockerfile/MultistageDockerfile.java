package de.oneaxis.gradle.docker.dockerfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultistageDockerfile implements Dockerfile {
    private final List<Dockerfile> dockerfiles;

    public MultistageDockerfile(final Dockerfile... dockerfiles) {
        this.dockerfiles = Arrays.asList(dockerfiles);
    }

    public MultistageDockerfile(final List<Dockerfile> dockerfiles) {
        this.dockerfiles = dockerfiles;
    }

    public MultistageDockerfile() {
        this.dockerfiles = new ArrayList<>();
    }

    public void addDockerfie(final Dockerfile dockerfile) {
        this.dockerfiles.add(dockerfile);
    }

    @Override
    public String parse() {
        return dockerfiles.stream()
                .map(Dockerfile::parse)
                .collect(Collectors.joining("\n\n"));
    }
}
