NOTE: This is the main repository. For simplicity, the initial intent was to use React frontend inside Spring Boot by using  `frontend-maven-plugin` plugin. The frontend code is located in `src\main\product-catalog-frontend` but I created a copy in a dedicated repository for frontend only:

https://github.com/sxkochetkov/product-catalog-frontend

Please, read more about it in `Dev Notes` section.

### Objective
Develop a retail product catalog application with a backend that supports fuzzy searching of products to accommodate for user input errors and approximations. The frontend will provide a user-friendly interface to search and display products.

### Functional Requirements
- Develop a REST API that:
  - Accepts a JSON payload and adds a new product into the system
  - Can retrieve all products as paginated list
  - Can retrieve details for a specified product
  - Can search for products with Fuzzy Search capability by product name

### Assumptions
- Product names are unique (for non-unique names please see suggestion discussed in `Data Modeling and Storing` section below)
- All data is in correct format
- Data is not normalized (no relationships are enforced such as product-categories)

### Design Considerations

#### Data Modeling and Storing
Since the assignment does not involve any persistence and use cases do not care about normalization and property relationships and ordering, it is suggested to use `HashMap` for indexing data (as key on product name) to make is searchable with fast access O(1) to indexes (product name).
The downside of this approach is that key can be not unique but this can be solved by storing as value List of products for same key.

Alternatively, if we care about ordering and uniqueness, this can be solved by using tree-like structures like heap (`PriorityQueue`) or red-black tree (`TreeSet`) that keeps data sorted and unique for example by timestamp, but it is expensive for writes.

#### Product lookup
There are indexes to speed up lookup but since we don't use any databases we need to create in-memory indexes. Hash index on product name is suggested as a key for `HashMap` but there is a tradeoff: if we need to do lookup for ids that decreases performance for reads.
Regarding fuzzy search algorithm, I was experimenting with string mutations.

### Dev Notes
Used [spring initializr](https://start.spring.io/) for generating Spring Boot web application (Java/Maven/Spring.Web).
To minimize environment set up, I am using just Maven.
For simplicity of packaging/installation I am shipping the application as one bundle (React as frontend inside Spring Boot) with help of `frontend-maven-plugin`. More information is here: https://github.com/eirslett/frontend-maven-plugin

*Note: My original intention was to have one repository for both frontend and backend and package application as one bucket for simplicity but if for some reason it doesn't work, alternatively, I commited the frontend in separated [repository](https://github.com/sxkochetkov/product-catalog-frontend), so the content of frontend repo can be copied into `src\main\product-catalog-frontend` directory. Frontend maven plugin will do the rest of npm commands.

For Search bar ideas I use code samples from here: https://github.com/CodeCompleteYT/react-search-bar

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

You will see live frontend update in: http://localhost:3000



### Running application in development environment (from project root folder)

*Before packaging and running application, please see Note in `Dev Notes` section about frontend.

#### Packaging the bundle (from to project root folder "retail-product-catalog")
```
$ .\mvnw package
```

Once the project is packaged, the jar can be run by:

`$ java -jar .\target\retail-product-catalog-0.0.1-SNAPSHOT.jar`

#### Options:
- For prepopulating product catalog, see `Configuration section` below. 
- To add a new product, use `Add New Product` button on the header. 
- To do product catalog search, use `Search Product` button. For demonstration fuzzy search capability I added products with similar names. Start typing `roedarv` and play around with it to see search results. Of course, for other searches, it needs to be added new products.
- Clicking on `Product List ()` should bring to product list view.
- To view product item details, click on product.

#### Configuration
There are two ways to prepopulate product catalog with products:

By using application
- Open application for the fist time (http://localhost:8080/) and press red `Here` button and then hit `Refresh` or F5. You will see Product List text shows now number of products.

By using REST API call:
- To prepopulate Product Catalog with data, use configuration API call: http://localhost:8080/config?action=prepopulate

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
