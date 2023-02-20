# Logback config with if-else for Stackoverflow

The [link](https://stackoverflow.com/questions/75514151/spring-boot-native-image-does-not-print-logs-when-logback-is-configured-with-con) to the Stackoverflow question.

## Most relevant files

- the [logback-spring.xml](src/main/resources/logback-spring.xml)
- the [main application class](src/main/java/foo/LogbackIfElseApplication.java)
- the [Gradle build script](build.gradle.kts)

## The problem

Running the program in the JVM yields the expected:

```shell
$ java -jar build/libs/logback-if-else-0.0.1-SNAPSHOT.jar 
2023-02-20T21:32:15.326+01:00  INFO 5905 --- [           main] foo.LogbackIfElseApplication             : Starting LogbackIfElseApplication using Java 17.0.5 with PID 5905
2023-02-20T21:32:15.329+01:00  INFO 5905 --- [           main] foo.LogbackIfElseApplication             : No active profile set, falling back to 1 default profile: "default"
2023-02-20T21:32:15.682+01:00  INFO 5905 --- [           main] foo.LogbackIfElseApplication             : Started LogbackIfElseApplication in 0.946 seconds (process running for 1.352)
2023-02-20T21:32:15.685+01:00  INFO 5905 --- [           main] foo.LogbackIfElseApplication             : Hello Logback!
Hello stdout
```

Running the native image unexpectedly only yields:

```shell
$ build/native/nativeCompile/logback-if-else
Hello stdout
```

## Reachability meta-data

The reachability meta-data in `src/main/resources/META-INF/native-image` has been generated with

```shell
./gradlew bootJar
java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar build/libs/logback-if-else-0.0.1-SNAPSHOT.jar
```

where

```shell
$ java -version
openjdk version "17.0.5" 2022-10-18
OpenJDK Runtime Environment GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08)
OpenJDK 64-Bit Server VM GraalVM CE 22.3.0 (build 17.0.5+8-jvmci-22.3-b08, mixed mode, sharing)
```