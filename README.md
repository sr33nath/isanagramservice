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
for most of my career, I thought why now make it a simple API? 
Let's use springboot and Java 17 to build a simple app which responds to an HTTP call with two strings and tells the 
caller in plain English if those strings are anagrams of each other or not. And meanwhile write a few unit tests and 
some integration tests using JUnit 5 and Mockito on the way. Can't go wrong with using maven as the build tool also.

And there you have the "Is Anagram" service. If you want to 
have a look at the API spec see the section [below](#specifications).

## API Specifications <a name="specifications"></a> ##

## How To <a name="howto"></a> ##
