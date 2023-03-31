Compilation
=================
* In order to compile and package with maven, execute the following command: 

    mvn clean package

Execution
=================
* Execute with any JVM 8 compatible version on the same rute the compilation step was executed: 

    java -jar calculator.jar

* Requests can be made from the browser. For example: 
    -   http://localhost:8080/api/v1/calculator/add?operands=2,3
    -   http://localhost:8080/api/v1/calculator/subtract?operands=2,3

Documentación API
=================
[API Documentation](https://github.com/RaulMGT/Calculator-Microservice/calculator-swagger.json)

You can also visualize the API documentation in pretty format following the next steps:
1. Access URL https://editor.swagger.io/ 
2. File -> Import URL -> https://github.com/RaulMGT/Calculator-Microservice/calculator-swagger.json

Warning: Executing requests from swagger will not work. Requests will be blocked by CORS policy.