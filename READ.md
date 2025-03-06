# testcontainers-spring-boot-with-mysql

This project is a Spring Boot application that integrates with MySQL using Testcontainers for testing. It provides two ways to run the application:
1. Running MySQL in Docker while the application runs locally.
2. Running both the application and MySQL inside Docker using Docker Compose.

## Prerequisites
Ensure you have the following installed:
- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Project Structure
```
testcontainers-spring-boot-with-mysql/
│── src/                         # Application source code
│── target/                      # Compiled JAR files (after mvn package)
│── Dockerfile                   # Dockerfile for Spring Boot application
│── docker-compose.yml            # For running MySQL in Docker (app runs locally)
│── docker-compose-app.yml        # For running both MySQL and App in Docker
│── pom.xml                       # Maven build configuration
│── README.md                     # Documentation
```

## Running the Application

### **Scenario 1: Running MySQL in Docker & App Locally**
mvn clean install -DskipTests
docker-compose -f docker-compose-app.yml up --build -d

1. Start MySQL in Docker:
   ```
   docker-compose up -d
   ```
2. Run the application locally:
   ```
   mvn spring-boot:run
   ```
3. Connect to MySQL using:
   ```
   JDBC URL: jdbc:mysql://localhost:3306/mydb
   User: mkyong
   Password: password
   ```
4. To stop MySQL:
   ```sh
   docker-compose down
   ```

### **Scenario 2: Running Both MySQL & App in Docker**
1. Build and start both services:
   ```sh
   docker-compose -f docker-compose-app.yml up --build -d
   ```
2. The application should use:
   ```
   JDBC URL: jdbc:mysql://mysql:3306/mydb
   User: mkyong
   Password: password
   ```
3. To stop and remove containers:
   ```sh
   docker-compose -f docker-compose-app.yml down
   ```

## **Building and Running the Application with Docker Manually**
1. Package the application:
   ```sh
   mvn clean package
   ```
2. Build the Docker image:
   ```sh
   docker build -t testcontainers-spring-boot-with-mysql .
   ```
3. Run the container (if MySQL is running separately):
   ```sh
   docker run --name app_container -p 8080:8080 --network="host" testcontainers-spring-boot-with-mysql
   ```

## **Environment Variables Used in `docker-compose-app.yml`**
| Variable | Description |
|----------|-------------|
| `SPRING_DATASOURCE_URL` | MySQL JDBC URL |
| `SPRING_DATASOURCE_USERNAME` | MySQL username |
| `SPRING_DATASOURCE_PASSWORD` | MySQL password |

## **Testing with Testcontainers**
This project includes **Testcontainers** dependencies to spin up an ephemeral MySQL container for integration testing.
Run tests using:
```sh
mvn test
```

## **Stopping and Cleaning Up**
To stop all containers and remove volumes:
```sh
docker-compose -f docker-compose-app.yml up
docker-compose -f docker-compose-app.yml down -v
```

## **Contributing**
Feel free to fork the repository and submit pull requests.

## **License**
This project is licensed under the MIT License.

