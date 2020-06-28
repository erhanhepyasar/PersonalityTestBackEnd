Spring Boot Back-End Project for Personality Test Application

Architecture:

Back-end and front-end parts are decoupled from each other as separate projects communicating over HTTP with Rest calls.

Back-End Project Technologies:

Spring Boot  (Spring Data JPA, H2 Database, Spring Web)
Java8
Maven
JPA-Hibernate
H2 in memory database
Multi-layered architecture (Model, Repository, Service, Controller )
Restful api's

Application Properties:

Application properties were set in "src/main/resources/application.properties" file.
Server Port number:  8085
Database: H2
Show beautified sql queries in console was set to true

H2 In-Memory Database:

Data in "personality_test.json" are embedded in "src/main/resources/data.sql" file  which fills H2 database automatically during application startup.
Conneciton Url for H2 Database:

http://localhost:8085/h2-console

