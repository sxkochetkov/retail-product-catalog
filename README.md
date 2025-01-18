
### Objective
Develop a retail product catalog application with a backend that supports fuzzy searching of products to accommodate for user input errors and approximations. The frontend will provide a user-friendly interface to search and display products.

### Functional Requirements
- Develop a REST API that:
  - Accepts a JSON payload and adds a new product into the system
  - Can retrieve all products as paginated list
  - Can retrieve details for a specified product
  - Can search for products with Fuzzy Search capability by product name
     
### Dev Notes
Used [spring initializr](https://start.spring.io/) for generating Spring Boot web application (Java/Maven/Spring.Web).
To minimize environment set up, I am using just Maven.
For simplicity of packaging/installation I am shipping the application as one bundle (React as frontend inside Spring Boot) with help of `frontend-maven-plugin`. More information is here: https://github.com/eirslett/frontend-maven-plugin

For frontend local development changes: 
```
$ cd retail-product-catalog\src\main\product-catalog-frontend
$ npm start
```

You will see live frontend update in:

localhost:3000

#### Packaging the bundle:
```
$ cd retail-product-catalog
$ .\mvnw package
```

#### Running application in development environment (from root folder):

`$ java -jar .\target\retail-product-catalog-0.0.1-SNAPSHOT.jar`

Depenencies versions
```
Npm version: 10.9.2
Node version: v22.13.0
```
