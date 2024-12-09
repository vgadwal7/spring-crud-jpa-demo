# Spring Boot REST CRUD API

This project is a **Spring Boot** application providing a **RESTful API** for managing resources (e.g., customers). It supports basic CRUD operations: Create, Read, Update, and Delete.

---

## Features

- Create new resources.
- Retrieve a list of all resources.
- Retrieve a single resource by its ID.
- Update an existing resource.
- Delete a resource by its ID.

---

## Technologies Used

- **Java 17**
- **Spring Boot** (2.x or 3.x)
- **Spring Data JPA**
- **H2 Database** (In-memory database)
- **Maven**
- **Docker** (optional)
- **Minikube** (for Kubernetes deployment, optional)

---

## Prerequisites

Before running this project, ensure you have the following installed:

1. **Java 17** or later
2. **Maven**
3. **Docker** (for containerization, optional)
4. **Minikube** and **kubectl** (for Kubernetes deployment, optional)

---
## APIs

### Endpoints
- `POST api/customer`: Add a new customer.
- `POST /api/customers`: Retrieve all customers.
- `GET /customer/{id}`: Retrieve a specific customer by ID.
- `PUT /customer/{id}`: Update a specific customer.
- `DELETE /customer/{id}`: Delete a specific customer by ID.

## How to Use
1. Clone the repository:
   ```bash
   git clone <repository>
   cd <repository>
   ```
2. Build the Project
   ```bash
   mvn clean package
   ```
3. Run the Application:
    ```bash
   java -jar target/<your-app>.jar
   ```
5. Build the Docker Image:
    ```bash
     docker build -t spring-rest-crud-api:latest .
    ``` 
7. Run the Docker Container
    ```bash
      docker run -p 8080:8080 spring-rest-crud-api:latest
    ```   
9. Start Minikube
   ```bash minikube start ``` 
  
10. Build the Docker Image in Minikube's Docker Environment
   ```bash 
     eval $(minikube docker-env)
     docker build -t spring-rest-crud-api:latest .
  ```
  
12. Apply Kubernetes Configurations
   ```bash 
    kubectl apply -f deployment.yaml
    kubectl apply -f service.yaml
   ```
11. Access the Application
    ```bash   minikube service spring-rest-crud-api --url  ```
  
11. Capture the service url and suffix the api's on postman to see the results.

12. Log on to H2 ui using the service url from 9 suffixed with http://<minikube-service-url>/h2-ui/ to see the results in db.
     
## CI/CD using github actions 
  
11. Add GitHub Actions secrets   
   - DOCKERHUB_USERNAME	The username of the Docker Hub user
   -  DOCKERHUB_TOKEN	The personal token of the Docker Hub user. I show how to generate it in this post
   - SERVER_HOST	The IP address of the server where your application is running on Docker
   - SERVER_PORT	The server SSH port. It is port 22 by default
   - SERVER_USER	The user to connect to the server with
   - SERVER_KEY	The private SSH key of the server

Create a commit of the changes, push the changes to the remote repository, and go to the GitHub repository to create a pull request.Once the pull request is created, scroll to the bottom, and you will see a running GitHub Action having the name "Spring JPA Demo application workflow".If you click on the link labeled as "Details", on the page displayed, you click on the menu "Summary" located at the top left, you will see the following schema of your GitHub Actions workflow
     
