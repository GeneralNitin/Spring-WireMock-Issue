### Little Background
This is a sample application I created to reproduce the issue we are facing with our application.
We are using WireMock to create a stub server for a use case.

### Issue
The things are working fine with SpringBoot 3.1.1 but when we upgrade to 3.2.5, the application is not able to start and throwing the below error:
<details>
<summary>Click me to see logs</summary>

```
2024-05-21T16:25:52.149+05:30 ERROR 89839 --- [wiremock-stub-server] [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'myAppMock' defined in class path resource [com/generalnitin/wiremockstubserver/config/WireMockConfiguration.class]: Failed to instantiate [com.github.tomakehurst.wiremock.WireMockServer]: Factory method 'myAppMock' threw exception with message: nested:/Users/I514807/Work/RefApps/wiremock-stub-server/target/wiremock-stub-server-0.0.1-SNAPSHOT.jar
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:648) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:485) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1335) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1165) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:562) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:962) ~[spring-context-6.1.6.jar!/:6.1.6]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.6.jar!/:6.1.6]
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343) ~[spring-boot-3.2.5.jar!/:3.2.5]
        at com.generalnitin.wiremockstubserver.WiremockStubServerApplication.main(WiremockStubServerApplication.java:10) ~[!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:91) ~[wiremock-stub-server-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.launch.Launcher.launch(Launcher.java:53) ~[wiremock-stub-server-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.launch.JarLauncher.main(JarLauncher.java:58) ~[wiremock-stub-server-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.github.tomakehurst.wiremock.WireMockServer]: Factory method 'myAppMock' threw exception with message: nested:/Users/I514807/Work/RefApps/wiremock-stub-server/target/wiremock-stub-server-0.0.1-SNAPSHOT.jar
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:177) ~[spring-beans-6.1.6.jar!/:6.1.6]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:644) ~[spring-beans-6.1.6.jar!/:6.1.6]
        ... 26 common frames omitted
Caused by: java.nio.file.NoSuchFileException: nested:/Users/I514807/Work/RefApps/wiremock-stub-server/target/wiremock-stub-server-0.0.1-SNAPSHOT.jar
        at java.base/sun.nio.fs.UnixException.translateToIOException(UnixException.java:92) ~[na:na]
        at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:106) ~[na:na]
        at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:111) ~[na:na]
        at java.base/sun.nio.fs.UnixFileAttributeViews$Basic.readAttributes(UnixFileAttributeViews.java:55) ~[na:na]
        at java.base/sun.nio.fs.UnixFileSystemProvider.readAttributes(UnixFileSystemProvider.java:148) ~[na:na]
        at java.base/java.nio.file.Files.readAttributes(Files.java:1851) ~[na:na]
        at java.base/java.util.zip.ZipFile$Source.get(ZipFile.java:1428) ~[na:na]
        at java.base/java.util.zip.ZipFile$CleanableResource.<init>(ZipFile.java:718) ~[na:na]
        at java.base/java.util.zip.ZipFile.<init>(ZipFile.java:252) ~[na:na]
        at java.base/java.util.zip.ZipFile.<init>(ZipFile.java:181) ~[na:na]
        at java.base/java.util.zip.ZipFile.<init>(ZipFile.java:195) ~[na:na]
        at com.github.tomakehurst.wiremock.common.ClasspathFileSource.<init>(ClasspathFileSource.java:74) ~[wiremock-standalone-3.0.0-beta-8.jar!/:na]
        at com.github.tomakehurst.wiremock.common.ClasspathFileSource.<init>(ClasspathFileSource.java:48) ~[wiremock-standalone-3.0.0-beta-8.jar!/:na]
        at com.generalnitin.wiremockstubserver.config.WireMockConfiguration.myAppMock(WireMockConfiguration.java:28) ~[!/:0.0.1-SNAPSHOT]
        at com.generalnitin.wiremockstubserver.config.WireMockConfiguration$$SpringCGLIB$$0.CGLIB$myAppMock$0(<generated>) ~[!/:0.0.1-SNAPSHOT]
        at com.generalnitin.wiremockstubserver.config.WireMockConfiguration$$SpringCGLIB$$FastClass$$1.invoke(<generated>) ~[!/:0.0.1-SNAPSHOT]
        at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258) ~[spring-core-6.1.6.jar!/:6.1.6]
        at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[spring-context-6.1.6.jar!/:6.1.6]
        at com.generalnitin.wiremockstubserver.config.WireMockConfiguration$$SpringCGLIB$$0.myAppMock(<generated>) ~[!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:140) ~[spring-beans-6.1.6.jar!/:6.1.6]
        ... 27 common frames omitted
```
</details>

As I read through the release notes I found this: [Nested Jar Support](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes#nested-jar-support)
Due to this change, the application is not able to start.

### Steps to run the application and reproduce the issue
1. Clone the repository
2. Build the project using `mvn clean install`
3. Run the application using `java -jar ./target/wiremock-stub-server-0.0.1-SNAPSHOT.jar`
4. Application runs fine
5. Try hitting `http://localhost:8555/hello/mock/health` returns 200 OK

To reproduce the issue follow the below steps:
1. Checkout to branch `feat/upgrade-spring-boot`
2. Build the project using `mvn clean install`
3. Run the application using `java -jar ./target/wiremock-stub-server-0.0.1-SNAPSHOT.jar`
4. Application fails to run.
