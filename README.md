# docker-gradle-plugin

## Description
This plugin follows the purpose of integrating Docker file creation into gradle
builds. For now, these are the file options available that the plugin API offers:
- Dockerfile

For upcoming releases, its planned to integrate docker-compose file creation.

## API
### Dockerfile
To get an idea of how this plugin works, you first need to understand the concept 
behind it. Its as simple as: 

> A __Dockerfile__ contains __commands__. A __Dockerfile__ could
contain __multiple stages__ (multistage Dockerfile).

And that is the simple, abstract look at how Dockerfiles are composed.

#### Configuration
##### Task
- Name: `createDockerfile`

##### Parameters
- `filePath`: Dockerfile storage path (including filename).
- `dockerfile`: Dockerfile content.

##### Commands
A list of supported Docker commands and its counterpart for integration in
the `build.gradle`:

| Dockerfile 	| Gradle            	|
|------------	|-------------------	|
| CMD        	| cmdCommand        	|
| COPY       	| copyCommand       	|
| ENTRYPOINT 	| entrypointCommand 	|
| EXPOSE     	| exposeCommand     	|
| FROM       	| fromCommand       	|
| RUN        	| runCommand        	|
| USER       	| userCommand       	|
| WORKDIR    	| workdirCommand    	|

#### Example
```groovy
createDockerfile {
    filePath = file("$project.rootDir/Dockerfile")
    dockerfile = multistageDockerfile(
            dockerfile(
                    fromCommand('gradle:5.3.0-jdk11-slim'),
                    userCommand('root'),
                    workdirCommand('/builder'),
                    copyCommand('.', '.'),
                    runCommand('gradle', 'build')
            ),
            dockerfile(
                    fromCommand('openjdk:11.0-jre-slim'),
                    workdirCommand('/app'),
                    copyCommand('0', '/builder/build/libs/app.jar', '.'),
                    exposeCommand(9090, 8080),
                    entrypointCommand('java', '-Djava.security.egd=file:/dev/./urandom', '-jar', './app.jar')
            )
    )
}
```

First we declare a `filePath` to assign a location where the Dockerfile will get
written at. Then we assign 1..n Dockerfile compositions to the `dockerfile` 
parameter. If we want to create a simple Dockerfile, we directly use the method
`dockerfile()`. If we want multiple stages inside our Dockerfile, we use 
`multistageDockerfile()` as a pseudo-wrapper first. The `dockerfile()` method
then takes any argument we want to be part of the Dockerfile. The command order
also defines the final position in the Dockerfile itself.