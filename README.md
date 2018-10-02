# CDI Logger

Logger injection strategy for CDI. 

This injector use the standard logging library `java.util.logging.*` to log.

## Getting started

### Add dependency

#### Gradle
```groovy
compile group: 'io.github.pablobastidasv', name: 'cdi-simple-logger', version:{version}
```

#### Maven
```xml
<dependencies>
    <groupId>io.github.pablobastidasv</groupId>
    <artifactId>cdi-simple-logger</artifactId>
    <version>{version}</version>
</dependencies>
```

### In your code

You must work in a java project with CDI 1.+/2.+ support. You must inject the Logger in your
cdi managed class and then used.

````java
private Logger log;

@Inject
public setLogger(Logger log){
    this.log = log;
}

public void doSomething(){
    log.debug("This method is doing something");
}

````