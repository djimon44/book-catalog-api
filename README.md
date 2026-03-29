# Book Catalog API

A RESTful API for managing a catalog of books, built with Spring Boot and PostgreSQL.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5
- Mockito

## How to Run

1. Clone the repository and navigate to the project root.
2. Make sure you have Java 17 and PostgreSQL installed.
3. Create a PostgreSQL database and update the connection details in `src/main/resources/application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
4. Build and run the application:
   ```
   ./mvn spring-boot:run
   mvnw.cmd spring-boot:run (On Windows)
   ```

The API will be available at `http://localhost:8080`.

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/books` | Retrieve all books |
| GET | `/api/books/{id}` | Retrieve a single book by ID |
| POST | `/api/books` | Create a new book |
| PUT | `/api/books/{id}` | Update an existing book by ID |
| DELETE | `/api/books/{id}` | Delete a book by ID |
