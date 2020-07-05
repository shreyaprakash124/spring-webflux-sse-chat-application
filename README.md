# Small chat application using Spring web flux , SSE and postgresSql

A small one and one chat application using Spring Web Flux and Server sent Events and PostgreSql.

![Image of sse and webflux](https://i.ibb.co/BNpvcCR/image.png)

# Table of contents
* [General info](#general-info)
* [Thought process and problem statement](#thought-process-and-problem-statement)
* [Screenshots](#screenshots)
* [Topics](#topics)
* [Demo](#demo)

## General info
Server-Sent-Events, or SSE for short, is an HTTP standard that allows a web application to handle a unidirectional event stream and receive updates whenever the server emits data.
In this project, we make use of implementations such as the Flux class provided by the Reactor library, or potentially the ServerSentEvent entity, which gives us control over the events metadata.

Flux is a reactive representation of a stream of events – it's handled differently based on the specified request or response media type. An SSE is a specification adopted by most browsers to allow streaming events unidirectionally at any time.
The **events** are just a stream of UTF-8 encoded text data that follow the format defined by the specification.

## Thought process and problem statement
This application is designed to provide the user with a real-time one an one chat platform .
The idea is to take advantage of the Reactive Stream Specification to build a non-blocking reactive chat application. 
In this case, I've achieved a non-blocking operation using Spring's web-flux framework and implemented Server-Sent-Events(SSE) in java spring.
For the desired result I established a stream connection based on the channel Id the purpose of the channel Id is to create a chat group in which one or more user can send/receive messages.

## Screenshots
<img align="left" src="https://i.ibb.co/YhnKnGN/converstaion.png">
<img align="center" width="1000px" src="https://i.ibb.co/dKmzS1H/swaggerchat.png">
<img align="center" width="1000px" src="https://i.ibb.co/5YdK3hk/swagger-Image.png">

## Topics
- Spring web flux 
- SSE
- Swagger
- Thymeleaf
- HTML,CSS,JS 
- PostgreSql
- Heroku

## Demo

The purpose of this one an one chat sytsem to provide the users a channel where they can send/receive messages to/from another users.
In Order to post/publish a message to the channel use the swagger link below.

```
https://chat-application-webflux-sse.herokuapp.com/swagger-ui.html
```

In order to subscribe to the channel and get all the relevant message for that channel go to the below link

```
https://chat-application-webflux-sse.herokuapp.com/?channelId=channelId
```

</br>
Click on try out for /messages for a POST call.
Use the below sample Json for creating the request.

```
{
"message":"Hi there!!",
"receiver":"Sunil",
"sender":"Shreya",
"channelId":"Channel1"
}
```

