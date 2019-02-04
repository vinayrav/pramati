# Spring Boot Demo
Minimal Spring Boot sample app.

## Installation
Download Spring Tool suite latest version
 *https://spring.io/tools*

## Usage
```
Create Spring Starter project
Create inmemomry database h2
                        i.e(spring.h2.console.enabled=true
                            spring.datasource.platform=h2
                            spring.datasource.url=jdbc:h2:mem:tab)
Create an interface that extends JpaRepository.
Create jsp (view page) in webapp folder i.e src->main-webapp->name.jsp
(Mention the changes in application properties if the file is saved in other folder)
```
## Dependencies to include
```
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>9.0.14</version>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>2.1.2.RELEASE</version>
</dependency>
		

```
## Files Included
**Files included in this project**
- Data
- DataController
- Data Repo
- Security Config
- home.jsp
- show.jsp
- Data.sql

## Sample Curl Request
```
curl -X GET   http://localhost:8080/data   -H 'Authorization: Basic dm55OnF3ZXJ0eQ=='   -H 'Content-Type: application/json' 
```
