
### Objective
Develop a retail product catalog application with a backend that supports fuzzy searching of products to accommodate for user input errors and approximations. The frontend will provide a user-friendly interface to search and display products.

### Functional Requirements
- Develop a REST API that:
  - Accepts a JSON payload and adds a new product into the system
  - Can retrieve all products as paginated list
  - Can retrieve details for a specified product
  - Can search for products with Fuzzy Search capability by product name
     
### Design Considerations

#### Data Modeling and Storing
Since the assignment does not involve any persistence and use cases do not care about normalization and property relationships and ordering, it is suggested to use HashMap for indexing data (as key on product name) to make is searchable with fast access O(1) to indeces (product name).

Alternatively, if we care about ordering and uniqueness, this can be solved by using tree-like structures like heap (PriorityQueue) or red-black tree (TreeSet) that keeps data sorted and unique for example by timestamp, but it is expensive for writes.

### Dev Notes
Used [spring initializr](https://start.spring.io/) for generating Spring Boot web application (Java/Maven/Spring.Web).
To minimize environment set up, I am using just Maven.
For simplicity of packaging/installation I am shipping the application as one bundle (React as frontend inside Spring Boot) with help of `frontend-maven-plugin`. More information is here: https://github.com/eirslett/frontend-maven-plugin

Dependencies versions
```
Npm version: 10.9.2
Node version: v22.13.0
```

For frontend local development changes: 
```
$ cd retail-product-catalog\src\main\product-catalog-frontend
$ npm start
```

You will see live frontend update in:

http://localhost:3000

#### Packaging the bundle:
```
$ cd retail-product-catalog
$ .\mvnw package
```

#### Running application in development environment (from root folder):

`$ java -jar .\target\retail-product-catalog-0.0.1-SNAPSHOT.jar`

#### Configuration
To prepopulate Product Catalog with data, use configuration API call:

http://localhost:8080/config?action=prepopulate

### Potential Improvements
For production ready code we need to know context better where service will be running as well as specifying non-functional requirements that will help to estimate workloads and risks. Further improvements/enhancements I would consider:
- Keeping code clean and simple, think about others, be careful with code comments - they can easily become outdated and confusing.
- Enabling logging in critical or potentially critical pieces of code: define different levels of logging (info, debug, error). Make sure that all logs are easily acceptable when service is running.
- Enhancing with input validation and defining how to deal in case if input is in incorrect format.
- Enabling exception and error handling mechanics with clear strategy how flow should react when something happens in services.
- Using TODOs if something can be addressed later with task ref which can help later to identify areas to improve.
- Code coverage - maximise unit testing, better define edge cases, involve end-to-end testing, make all tests are part of build/deployment pipeline.
- Stress/loading testing (for example with Gatling).

For JVM/Memory measures for troubleshooting I would consider:
- Enabling GC log in prod to see what insights we will get from the GC log to tune the JVM
- Using Tools such as JFR/JDK Mission Control, JMX, jcmd/jstat, Async-profiler (good for both native and java profiling) for Memory Analysis (Java Heap Dump) can help troubleshooting memory issues like memory leaks and high usage of memory.

Infrastructure measures:
- For service oriented deployment, enable sidecar agents for distributed tracing to profile and monitor services.
- Considering aggregating logs and metrics in centralize location (e.g. ELK stack).
- Thread modeling to identify potential security risks and mechanism to prevent threads (authorization/authentication etc.).
- Code security by using static code analysis tools or likewise.