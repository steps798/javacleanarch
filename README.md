# Clean Architecture Implementation
This repository is an example implementation of Clean Architecture, 
referring to `Get Your Hands Dirty on Clean Architecture` by Tom Hombergs.
While using the concept of Clean Architecture, this structure also adapts Hexagonal Architecture.

## When to use this structure?
The goal to implement this structure to a project is to decouple the dependency and business logics.
Consider this if the project has any possibility to change the dependency anytime.

## Thumb rules
* `domain` is the center and should depend on no dependency at all.
* `application` contains the business logic and could only depend on `domain`.
* `adapter` contains the actual implementation with the dependency.
* `out` means anything that the application produces as output, e.g. entity to be persisted in database, message to be published in message queue.
* `in` means anything that the application receives as input, e.g. request from web, message consumed from message queue.
* `common` contains any class that use in the application, e.g. constant, exception, util.
* `config` contains any general configuration or properties needed in the application.
* `external` contains any specific configuration or properties needed in `application` or `adapter`.
* if the project contains several applications and have common implementation, consider to pull up the package as its own module and let the application depends on it.
* understand that although the domain and the actual entity might look the same, they might be an incidental duplication.

### Disclaimer
any implementation of dependency is not actually implemented.
for architecture test, you can refer to `CleanArchitectureBoundaryTest`.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

