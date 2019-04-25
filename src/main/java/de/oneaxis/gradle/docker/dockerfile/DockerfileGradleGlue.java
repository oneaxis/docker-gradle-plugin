package de.oneaxis.gradle.docker.dockerfile;

import de.oneaxis.gradle.docker.dockerfile.instruction.*;

public interface DockerfileGradleGlue {
    default DefaultDockerfile dockerfile(final DockerfileInstruction... instructions) {
        return new DefaultDockerfile(instructions);
    }

    default MultistageDockerfile multistageDockerfile(final Dockerfile... dockerfiles) {
        return new MultistageDockerfile(dockerfiles);
    }

    default CmdInstruction cmd(final String... args) {
        return new CmdInstruction(args);
    }

    default CopyInstruction copy(final String origin, final String destination) {
        return new CopyInstruction(origin, destination);
    }

    default CopyInstruction copy(final String from, final String origin, final String destination) {
        return new CopyInstruction(from, origin, destination);
    }

    default EntrypointInstruction entrypoint(final String... args) {
        return new EntrypointInstruction(args);
    }

    default ExposeInstruction expose(final Integer... ports) {
        return new ExposeInstruction(ports);
    }

    default FromInstruction from(final String baseImage, final String tag) {
        return new FromInstruction(baseImage, tag);
    }

    default FromInstruction from(final String baseImage) {
        return new FromInstruction(baseImage);
    }

    default RunInstruction run(final String... args) {
        return new RunInstruction(args);
    }

    default UserInstruction user(final String user) {
        return new UserInstruction(user);
    }

    default WorkdirInstruction workdir(final String workdir) {
        return new WorkdirInstruction(workdir);
    }
}
