### Spring Cloud Config Server demo
using:
####[Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/reference/html/#_spring_cloud_config_server)
####[Spring Cloud Config Client](https://cloud.spring.io/spring-cloud-config/reference/html/#_spring_cloud_config_client)
####[Redis](https://redis.io/)
####[Exam](https://github.com/Adven27/Exam) - Acceptance TDD extension for Concordion
####[Env](https://github.com/Adven27/env) - Set of libs for microservice environment emulation


1. Build the jars
```groovy
gradle config-server:bootJar
gradle app-client:bootJar
```

2. Run tests
```groovy
gradle e2e-tests:test
```
3. See the spec at 
    ####e2e-tests/reports/specs/Specs.html

