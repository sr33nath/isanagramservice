# Is Anagram Service #

In this document you will find the specification for an API which will compare two strings 
and verify if they are anagrams of each other. This was done as part of an assignment. You can find the details of the 
assignment in the [requirements](#requirements) segment below.

# Table of Contents

1. [Description](#description)
    1. [Functional Requirements](#requirements)
    2. [API Specification](#specifications)
    3. [How To](#howto)


## Functional Requirements <a name="requirements"></a> ##

“Write a Java program that checks if two texts are anagrams of each other.

Please use the english wikipedia entry for the definition of anagram.
The solution has to be in Java or Kotlin.
Feel free to use your favourite IDE, unit test frameworks, automated build system etc.
You can prioritize however you like (performance, readability, extensibility, …).
Googling is a good thing :)”

## What was done? <a name="description"></a> ##

As part of the task I was only asked to write a Java program. But since it does not showcase what I have been doing 
for most of my career, I thought why not make it a simple API? 
Let's use springboot and Java 17 to build a simple app which responds to an HTTP call with two strings and tells the 
caller in plain English if those strings are anagrams of each other or not. And meanwhile write a few unit tests and 
some integration tests using JUnit 5 and Mockito on the way. Can't go wrong with using maven as the build tool also.

And there you have the "Is Anagram" service. If you want to 
have a look at the API spec see the section [below](#specifications).

## API Specifications <a name="specifications"></a> ##
You can follow this link [here](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/sr33nath/isanagramservice/main/isAnagram-openapi-3.0.3.yml) to see the API spec.

Request payload specification

|     Field      | JSON Type |                           Description                            |
|:--------------:|:---------:|:----------------------------------------------------------------:|
| `firstString`  |  String   | Any string with characters between unicode range 0x0000 - 0xFFFF |
| `secondString` |  String   | Any string with characters between unicode range 0x0000 - 0xFFFF |

* Currently the size or length of the input strings are not limited to any value since that was not part of 
the requirements. As long as the request payload falls below the size 2048KBytes, it will be accepted.
* P.S If the characters in the input string fall outside the unicode range 0x0000 - 0xFFFF, 
the program will return inconsistent results.

## How to run the service? <a name="howto"></a> ##

### Pre-requisites ###
Make sure all the below services are installed on the system where you want to run the service.
* `Windows 10`
* `Maven 3.9.3 (Windows)`
* `JDK 17.0.5 (Windows)`
* `Git 2.41.0 (Windows)`
* `curl 8.0.1 (Windows)`

### Steps ###

* Open command prompt and run the following commands one by one
* `git clone https://github.com/sr33nath/isanagramservice.git`
* `cd isanagramservice`
* `mvn clean verify`
* `mvn spring-boot:run`
* Open another command prompt window and run the below commands one by one
* `curl -H "Content-Type: application/json" -d "{\"firstString\":\"AAB\",\"secondString\":\"ABA\"}" http://localhost:8080/isAnagram` (Positive test)
* `curl -H "Content-Type: application/json" -d "{\"firstString\":\"AAB\",\"secondString\":\"ABC\"}" http://localhost:8080/isAnagram` (Negative test)