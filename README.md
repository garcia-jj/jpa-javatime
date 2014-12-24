jpa-javatime
============

![Build status](https://secure.travis-ci.org/garcia-jj/jpa-javatime.png)

A simple project with adapters to use `java.time` classes with JPA.

At this time JPA providers don't recognize `java.time` classes as temporal fields. So this project exists to solve this gap, adding some converters to allow us to use `java.time` classes in our projects.

To install you only need to add this artifact in your `pom.xml` if you are using Maven.

```xml
<dependency>
    <groupId>br.com.otavio</groupId>
    <artifactId>jpa-javatime</artifactId>
    <version>0.1</version>
</dependency>
```

Or if you don't like to use Maven or any dependency manager, you can copy the jar [available here](http://mvnrepository.com/artifact/br.com.otavio/jpa-javatime/0.1) to your project by your hands.
