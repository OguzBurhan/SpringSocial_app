# Spring Social Media App

## Description

The Spring Social Media App is a microservices-based social media platform developed using Spring Boot, Java, and Gradle. It leverages Docker for containerization of its services, ensuring scalability and easy deployment. The application features a Eureka server for service discovery, facilitating communication between its five distinct services. Users can sign up, send friendship requests, post text updates, and make comments, creating a dynamic and interactive social media experience.

## Features

- **User Authentication**: Secure sign up and sign in functionality.
- **Friendship Requests**: Users can send and receive friendship requests.
- **Text Posts**: Users can post text content to their timeline.
- **Comments**: Enables users to comment on posts.
- **Microservices Architecture**: Five separate services working together, managed through a Eureka server.
- **Docker Containerization**: Each service is containerized using Docker, simplifying deployment and scalability.

## Architecture

- **Discovery Service**: Service discovery and registration.
- **User Service**: Handles authentication and user management.
- **Friendship Service**: Manages friendship requests and relationships.
- **Post Service**: For creating and managing text posts.
- **Comment Service**: Allows users to comment on posts.

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/spring-social-media-app.git
