# docker-gradle-plugin

## Description
This plugin follows the purpose of integrating Docker file creation into gradle
builds. For now, these are the file options available that the plugin API offers:
- Dockerfile

For upcoming releases, its planned to integrate docker-compose file creation.

## First steps
To use this plugin add the following to your `build.gradle` file:

```groovy
plugins {
    // Add appropriate version from latest repository tag
    id 'de.oneaxis.gradle.docker.docker-gradle-plugin' version 'your_desired_version'
}
```

If you are retrieving the plugin sources from a custom artifact repository 
(like Nexus), add the following to your `settings.gradle` file: 

``` groovy
pluginManagement {
    repositories {
        maven {
//            credentials {
//                username my_username
//                password my_password
//            }
            url 'http://nexus.oneaxis.de/repository/maven-public/'
        }
    }
}
```

## API
### Dockerfile
To get an idea of how this plugin works, you first need to understand the concept 
behind it. Its as simple as: 

> A __Dockerfile__ contains __instructions__. A __Dockerfile__ could
contain __multiple stages__ (multistage Dockerfile).

And that is the simple, abstract look at how Dockerfiles are composed.

#### Configuration
##### Task
- Name: `createDockerfile`

##### Parameters
- `filePath`: Dockerfile storage path (including filename).
- `dockerfile`: Dockerfile content.

##### Instructions
A list of supported Docker instructions and its counterpart for integration in 
`build.gradle`:

| Dockerfile 	| Gradle            	|
|------------	|-------------------	|
| CMD        	| cmd        	        |
| COPY       	| copy       	        |
| ENTRYPOINT 	| entrypoint 	        |
| EXPOSE     	| expose     	        |
| FROM       	| from       	        |
| RUN        	| run        	        |
| USER       	| user       	        |
| WORKDIR    	| workdir    	        |

#### Example
```groovy
createDockerfile {
    filePath = file("$project.rootDir/Dockerfile")
    dockerfile = multistageDockerfile(
            dockerfile(
                    from('gradle:5.3.0-jdk11-slim'),
                    user('root'),
                    workdir('/builder'),
                    copy('.', '.'),
                    run('gradle', 'build')
            ),
            dockerfile(
                    from('openjdk:11.0-jre-slim'),
                    workdir('/app'),
                    copy('0', '/builder/build/libs/app.jar', '.'),
                    expose(9090, 8080),
                    entrypoint('java', '-Djava.security.egd=file:/dev/./urandom', '-jar', './app.jar')
            )
    )
}
```

First we declare a `filePath` to assign a location where the Dockerfile will get
written at. Then we assign 1..n Dockerfile compositions to the `dockerfile` 
parameter. If we want to create a simple Dockerfile, we directly use the method
`dockerfile()`. If we want multiple stages inside our Dockerfile, we have to use 
`multistageDockerfile()` as a pseudo-wrapper first. The `dockerfile()` method
then takes any argument we want to be part of the Dockerfile. The instruction order
also defines the final position in the Dockerfile itself.
