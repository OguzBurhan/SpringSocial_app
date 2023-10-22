# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application source code into the container
COPY . /app

# Specify the command to run your application
CMD ["java", "GbcSpringSocial54Application"]
