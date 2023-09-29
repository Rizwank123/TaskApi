
# Personal Task Manager

**Developer:** Mohammad Rizwan

**Project URL:** [GitHub Repository](https://github.com/Rizwank123/TaskApi)

**License:** Open Source

## Overview

The Personal Task Manager is a web application built using a combination of Spring Boot, Spring Security, Spring Data JDBC, Maven, PostgreSQL, JpaRepository, and OpenAPI 3. It provides a platform for users to manage their tasks effectively.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Authentication](#authentication)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Task Management**: Create, update, and delete tasks.
- **User Authentication**: Secure user authentication using Spring Security.
- **API Documentation**: API documentation provided using OpenAPI 3.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 11 or higher
- Apache Maven
- PostgreSQL Database
- Git
- Spring JDBC
- Spring Security 
- OpenApi 3
- Spring Data JPA

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Rizwank123/TaskApi.git
   ```

2. Navigate to the project directory:

   ```bash
   cd TaskApi
   ```

3. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```

The application will be accessible at `http://localhost:8080`.

## Authentication

The Personal Task Manager uses Spring Security for user authentication. Users can obtain a JWT token by sending a POST request to the `/api/getToken` endpoint with valid credentials. This token must be included in the `Authorization` header for subsequent requests to protected endpoints.

## API Endpoints

The API offers the following endpoints:

- **Create a Task**: `POST /api/tasks`
- **Get All Tasks**: `GET /api/tasks`
- **Get a Task by ID**: `GET /api/tasks/{taskId}`
- **Update a Task**: `PUT /api/tasks/{taskId}`
- **Delete a Task**: `DELETE /api/tasks/{taskId}`
- **Change Status** : `PATCH /api/tasks/`

For detailed API documentation, refer to the [OpenAPI Specification](./openapi.yaml) provided in the project.

## Contributing

Contributions to the Personal Task Manager project are welcome. Feel free to open issues and submit pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

You can use this template as your README.md file in your GitHub repository. Please replace the placeholders with actual content or URLs as needed.