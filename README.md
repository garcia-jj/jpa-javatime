jpa-javatime
============

![Build status](https://secure.travis-ci.org/garcia-jj/jpa-javatime.png) [![Coverage Status](https://img.shields.io/coveralls/garcia-jj/jpa-javatime.svg)](https://coveralls.io/r/garcia-jj/jpa-javatime)

A simple project with adapters to use `java.time` classes with JPA.

At this time JPA providers don't recognize `java.time` classes as temporal fields. So this project exists to solve this gap, adding some converters to allow us to use `java.time` classes in our projects.

To install you need to add this artifact in your `pom.xml` if you are using Maven.

```xml
<dependency>
    <groupId>br.com.otavio</groupId>
    <artifactId>jpa-javatime</artifactId>
    <version>0.2</version>
</dependency>
```

Or if you don't like to use Maven or any dependency manager, you can copy the jar [available here](http://mvnrepository.com/artifact/br.com.otavio/jpa-javatime/0.1) to your project by your hands.

And after you need to add the converters in your `persistence.xml` file:

```xml
<class>br.com.otavio.jpa.javatime.PersistentLocalDate</class>
<class>br.com.otavio.jpa.javatime.PersistentLocalDateTime</class>
<class>br.com.otavio.jpa.javatime.PersistentLocalTime</class>
<class>br.com.otavio.jpa.javatime.PersistentYearMonth</class>
```
