# CDI Logger

Logger injection strategy for CDI. 

This injector use the standar logging library `java.util.logging.*` to log.

## Way to use
### Add repository 

#### Gradle
``` groovy
maven {
    url "http://nexus-bassanco2.rhcloud.com/repository/maven-public"
}
```
##### Note
This repository is free so could not be working, in case you have a 503 error please wait 
for 2 minutes and try again.

### Add dependency

#### Gradle
```groovy
compile group: 'co.pablobastidasv', name: 'cdi-logger-api', version:'1.0-SNAPSHOT'
```

### In your code

You must work in a java project with CDI 1.1 support. You must inject the Logger in your
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