package de.oneaxis.gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.dockerfile.command.*;

public interface DockerfileGradleGlue {
    default DefaultDockerfile dockerfile(final DockerfileCommand... commands) {
        return new DefaultDockerfile(commands);
    }

    default MultistageDockerfile multistageDockerfile(final Dockerfile... dockerfiles) {
        return new MultistageDockerfile(dockerfiles);
    }

    default CmdCommand cmdCommand(final String... args) {
        return new CmdCommand(args);
    }

    default CopyCommand copyCommand(final String origin, final String destination) {
        return new CopyCommand(origin, destination);
    }

    default CopyCommand copyCommand(final String from, final String origin, final String destination) {
        return new CopyCommand(from, origin, destination);
    }

    default EntrypointCommand entrypointCommand(final String... args) {
        return new EntrypointCommand(args);
    }

    default ExposeCommand exposeCommand(final Integer... ports) {
        return new ExposeCommand(ports);
    }

    default FromCommand fromCommand(final String baseImage, final String tag) {
        return new FromCommand(baseImage, tag);
    }

    default FromCommand fromCommand(final String baseImage) {
        return new FromCommand(baseImage);
    }

    default RunCommand runCommand(final String... args) {
        return new RunCommand(args);
    }

    default UserCommand userCommand(final String user) {
        return new UserCommand(user);
    }

    default WorkdirCommand workdirCommand(final String workdir) {
        return new WorkdirCommand(workdir);
    }
}
