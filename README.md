# awin-recruitment-task

### General info

Project created for passing recruitment task in Awin's recruitment process.<br>
Creation date: 05.06.2022

Application aims at transaction enrichment - it provides simple logic for 
getting transactions with products and its price. 
Application does an enrichment - summing all prices for all products in each transaction and displays it as an output.

Application provides two versions (releases):
1. "Task 1 release" - CLI application which reads input from file (in JSON format), enriches it and provides all to the output
2. "Task 2 release" - instead of CLI there is exposed REST API with two endpoints for enrichment, both single and collection of transactions
with additional Docker support

### Authentication
Since "Task 2 release" there is enabled basic authentication with user and password to provide
some kind of "mock" of simple security ;) <br>
So to authenticate any request you should use below credentials:<br>
user: <code>user</code><br>
password: <code>awin</code>

### Swagger
"Task 2 release" shares REST API which can be invoked with Swagger.
Link: <url>http://localhost:8080/api/swagger-ui/index.html </url>

### How to build

##### MAVEN
Required JAVA version: 11 <br>
You can run the application by using
<code> ./mvnw spring-boot:run </code>
<br>
Alternatively, you can build the JAR file with
<code>./mvnw clean package</code>
and then run the JAR file, as follows:
<code>java -jar target/transactions-0.0.2-SNAPSHOT.jar</code>

##### DOCKER
There is included dockerfile which allows you to run application as container.<br>
Just execute following command:
<code>docker build -t transactions:1.0 .</code><br>
After a while you should be able to run the application:
<code>docker run -p 8080:8080 transactions:1.0 </code>

Author: Łukasz Woźniak
