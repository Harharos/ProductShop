# Product Management Back-End API

This project is a back-end API for managing products. It provides CRUD (Create, Read, Update, Delete) operations on a list of products through a RESTful API.

## Features

- Manage products with attributes such as `id`, `code`, `name`, `description`, `price`, `quantity`, `inventoryStatus`, `category`, `image`, and `rating`.
- Store products in a SQL/NoSQL database or a JSON file.
- RESTful API with the following operations:
  - Create new products
  - Retrieve all products
  - Retrieve product details by ID
  - Update product details
  - Delete products

## Installation

npm clean install
mvn clean install

### Prerequisites

- Java 17 installed
- Angular 14 installed
- Maven installed
- Lombok in your java workspace

### Steps to Set Up the Back-End

After cloning the repository:
   git clone https://github.com/your-repository.git

Follow these steps to set up and run the back-end service:

1. Navigate to the `back` directory:
   cd back
2- Build the projet using maven
	mvn clean install
3- Run the Spring Boot application:
	mvn spring-boot:run
4- The application will start on port 8081. Access it at:
	http://localhost:8081
5- Navigate to the front directory:
   cd front
6- Install the dependencies:
   npm install
7- Run the Angular application:
   ng serve
8- The application will start on port 4200. Access it at:
   http://localhost:4200

