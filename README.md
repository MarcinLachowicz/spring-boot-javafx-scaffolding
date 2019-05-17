# Scaffolding project for JavaFX and Spring Boot on Java 8 

Every time you need to start a new project using [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm) and [Spring Boot](https://spring.io/projects/spring-boot), you need to do some plumbing work.
This project enables you to skip this boring job and focus on your goal. 

It provides minimal setup for [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm) and [Spring Boot](https://spring.io/projects/spring-boot) along with sample test cases for *Spring* and UI.

## How to start

1. Prerequisites: *Java 8*, *Maven*
1. Fork this repository or download content.
1. Start coding your project!

<aside class="warnning">
Every https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm controller must be defined as Spring Bean. 
</aside>

## Features

1. Integration of [JavaFX](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm) and [Spring Boot](https://spring.io/projects/spring-boot) frameworks
1. Sample [JUnit5](https://junit.org/junit5/) test setup for *Spring-only*
1. Sample [JUnit5](https://junit.org/junit5/) test setup for UI tests using [TestFX](https://github.com/TestFX/TestFX)
1. UI tests are run in headless mode, it can be run on CI services like [Travis](https://travis-ci.org/)
1. Maven `windows-exe` that produces executable file using [launch4j-maven-plugin plugin](https://github.com/lukaszlenart/launch4j-maven-plugin)
1. Sample *FXML* file for UI definition

