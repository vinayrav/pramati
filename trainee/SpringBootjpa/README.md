# Spring Boot Demo
Minimal Spring Boot sample app.

## Requirement
Maven

## Usage
Download Spring Tool suite latest version
 *https://spring.io/tools*
Open the project in Spring Tool suite
    or
You can run it in terminal by the command **mvn spring-boot:run** 
- The application will run in `localhost` at port `8080`
- Provide the User Credentials
- To stop the server run `mvn -stop
## User Credentials
- Username:"vny"
- Password:"qwerty"

## Application
**Arguments**
- "bid":integer a unique identifier for the data
- "bname":string name for the data

## Adding Data
### Definition
**POST/data**
Sample Data
```
 {
        "bid": 9,
        "bname": "b8"
    }
```
RESPONSE
```
{
    "bid": 9,
    "bname": "b8"
}
```
## Getting complete Data
### Definition
**GET/data**
RESPONSE
```
[
    {
        "bid": 1,
        "bname": "b1"
    },
    {
        "bid": 2,
        "bname": "b2"
    },
    {
        "bid": 3,
        "bname": "b3"
    },
    {
        "bid": 9,
        "bname": "b8"
    }
]
```

## Getting Desired Data
### Definition
**GET/data/{id}**
SAMPLE RESPONSE 
```
{
    "bid": 3,
    "bname": "b3"
}
```
## Deleting specific entry
### Definition
**DELETE/data/{id}**
RESPONSE
```
deletedData [bid=9, bname=b8]
```
## Updating the Data
### Definition
**PUT/data**
RESPONSE
```
{
    "bid": 2,
    "bname": "changed"
}
```
## Sample Curl Request
```
curl -X GET   http://localhost:8080/data   -H 'Authorization: Basic dm55OnF3ZXJ0eQ=='   -H 'Content-Type: application/json' 
```
