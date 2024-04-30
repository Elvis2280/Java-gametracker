# Gametracker API
This is a simple API that allows you to get information about a game server. It uses the [Gametracker](https://gametracker-elvisdev.netlify.app/) website to get the information.

## Folder Structure
1. config - Contains the configuration files for the application, database and the server
2. controllers - Contains the api routes for the application
3. models - Contains the models which are used to interact with the database
4. dto - Contains the data transfer objects which are used to transfer data between the application and the client
5. services - Contains the services which are used to interact with the database
6. repositories - Contains the repositories which are used to interact with the database using the models
7. utils - Contains utility functions which are used throughout the application to perform common tasks
8. enums - Contains enums which are used throughout the application to represent constants

## Docker
To run the application using docker, you need to have docker installed on your machine. You can install docker by following the instructions [here](https://docs.docker.com/get-docker/).
You need to provide database credentials in the .env file in the root of the project. You can use the .env.example file as a template.
Docker-compose.local.yml is used to run the application locally. that create a database container for the local development environment.,

## Environment Variables
...

```This backend is deployed on Dokku, so you can use the Dokku CLI to deploy the application.```
