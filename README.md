# RailRoadSystems

## Overview
RailRoadSystems is a Spring Boot-based application designed to manage railroad operations, including the generation and management of Waybills and Bills of Lading. The system integrates with Kafka for event publishing and uses a relational database for data persistence.

## Features
- **Waybill Management**: Generate, update, and retrieve Waybills.
- **Bill of Lading Processing**: Process Bills of Lading to create Waybills.
- **Kafka Integration**: Publish Waybill events to Kafka topics.
- **REST API**: Expose endpoints for managing railroad operations.
- **Database Integration**: Store and retrieve data using a relational database.

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **Spring Data JDBC**: For database interactions.
- **Kafka**: For event-driven communication.
- **Maven**: Build and dependency management tool.
- **JUnit**: For unit testing.

## Prerequisites
- Java 17 or higher
- Maven 3.8 or higher
- Kafka server running on `localhost:9092`
- A relational database (e.g., MySQL, PostgreSQL)

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/RailRoadSystems.git
   cd RailRoadSystems