### Little Background
This is a sample application I created to reproduce the issue we are facing with our application.
We are using WireMock to create a stub server for a use case.

### Issue
The things are working fine with SpringBoot 3.1.1 but when we upgrade to 3.2.5, the application is not able to start and throwing the below error:
```
```

As I read through the release notes I found this: [Nested Jar Support](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes#nested-jar-support)
Due to this change, the application is not able to start.

### Steps to run the application and reproduce the issue
1. Clone the repository
2. Build the project using `mvn clean install`
3. Run the application using `java -jar ./target/wiremock-stub-server-0.0.1-SNAPSHOT.jar`

To reproduce the issue follow the below steps:
1. Checkout to branch `feat/upgrade-spring-boot`
2. Build the project using `mvn clean install`
3. Run the application using `java -jar ./target/wiremock-stub-server-0.0.1-SNAPSHOT.jar`
