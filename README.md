# MicroService by Spring Cloud

### Micro Service
- Rest
- Small Well Chosen Deployable Units
- Cloud Enabled

### Micro Service Advantage
- Faster new technology & process adoptation
- Dynamic Scaling
- Faster Release Cycle


### Micro Service Challanges
- Bounded Context
- Configuration Management 
    - Spring Cloud Config Server
- Dynamically Scale up and Scale Down
    - Naming Server (Euraka)
    - Ribbon (Client Side Binding)
    - Feign (Declarative Rest Client)
- Visibility
    - Zipkin Distributed Tracing
    - Netflix API Gateway
        - Authentication, authorization and security
        - Rate limits
        - Fault Tolerence
            - Hystrix
        - Service Aggregation

- Pack of Card - Caused for defect


### Micro Service Multi Instances

![Multi Instances Micro Services](Multi%20Instances%20Micro%20Services.png)


### Project Structure
![Project Architecture](Project%20Work%20Flow.PNG)

### [Spring Cloud](http://projects.spring.io/spring-cloud/)

Spring Cloud is tool for building system using common pattern in Distributed System.

### Pattern used in Spring Cloud
- Configuration Management
- Service Discovery
- Circuit Breaker
- Intelligent routing
- Micro Proxy
- Control Bus
- One Time Tokens
- Global Locks
- Leadership Election
- Distributed Session
- Cluster State

### Used Spring Cloud Project List

- Spring Cloud Config 
```
    Centralized external configuration management backed by a git repository. 
    The configuration resources map directly to Spring `Environment` 
    but could be used by non-Spring applications if desired.
```    
- Spring Cloud Netflix
    - Service Discovery: 
        ```
        Eureka instances can be registered and clients can discover the instances using Spring-managed beans

        An embedded Eureka server can be created with declarative Java configuration
        ```
    - Circuit Breaker
        ```
        Hystrix clients can be built with a simple annotation-driven method decorator
        
        Embedded Hystrix dashboard with declarative Java configuration
        ```

    - Declarative REST Client
        ```
        Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations
        ```
    - Client Side Load Balancer: Ribbon
    - External Configuration
        ```
        A bridge from the Spring Environment to Archaius (enables native configuration of Netflix components using Spring Boot conventions)
        ```
    - Router and Filter
        ```
        Automatic regsitration of Zuul filters, and a simple convention over configuration approach to reverse proxy creation
        
        ```
  
- Spring Cloud Bus
    ```
    An event bus for linking services and service instances together with distributed messaging. 
    Useful for propagating state changes across a cluster (e.g. config change events).
    ```
- Spring Cloud Sleuth

    ```
    Distributed tracing for Spring Cloud applications, compatible with Zipkin, HTrace and log-based (e.g. ELK) tracing.
    ```

- Spring Cloud OpenFeign
    ```
    Provides integrations for Spring Boot apps through autoconfiguration and binding to the Spring Environment and other Spring programming model idioms.
    ```
- Zipkin Server (Not part of Spring Cloud)
- Rabbit MQ (Not part of Spring Cloud)



### Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
|  |  |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |



## URLs

|     Application       |     URL          |
| ------------- | ------------- |
| Limits Service | http://localhost:8080/limits POST -> http://localhost:8080/actuator/refresh|
|Spring Cloud Config Server| http://localhost:8888/limits-service/default http://localhost:8888/limits-service/dev |
|  Currency Converter Service - Direct Call| http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10|
|  Currency Converter Service - Feign| http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000|
| Currency Exchange Service | http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR|
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | Post -> http://localhost:8080/actuator/bus-refresh |


### Other important commands

#### Rabbit MQ Commands
```
cd ZipkinServer
set RABBIT_URI=amqp://localhost 
java -jar zipkin-server-2.10.2-SNAPSHOT-exec.jar
```

#### VM Argument to create new instances

```
-Dserver.port=8001
```


#### Git Commands

```
mkdir git-configuration-repo
cd git-configuration-repo/
git init
git add -A
git commit -m "first commit"
```

#### Acutator Endpoints Enable
```
management.security.enabled=false
management.endpoints.web.exposure.include=*
```


## More Reading about Microservices
- Design and Governance of Microservices
    - https://martinfowler.com/microservices/
- 12 Factor App 
    - https://12factor.net/
    - https://dzone.com/articles/the-12-factor-app-a-java-developers-perspective
- Spring Cloud
    - http://projects.spring.io/spring-cloud/
- Spring Design Patterns
    - http://microservices.io/patterns/microservices.html