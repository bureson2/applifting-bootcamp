# Java Bootcamp 2022 - Testing

## Prerequisites

- JDK 17 or higher
- Maven 3 or higher

## Run the application

```sh
./mvnw spring-boot:run
```

## Tasks

### Description

Create an Order system that takes an order with its lines, validates, persists, and send Order placed e-mail to the customer.

Model the system to handle following data:

#### Order line

- a product code, must starts with 'W' then following 4 digits, or starts with 'G' then following 3 digits
- a quantity could be units in positive integer
- a current shipment supplier can take it only 1000 units per an order

#### Customer info

- contains a valid e-mail address

#### Order

- holds order lines and customer info

### Task 1

- Model a domain with the requirements
- Write unit tests for the domain

### Task 2

- Encapsulate the domain into a service
- Write a controller for taking an order
- Write component tests

### Task 3

- Write tests for the controller

### Task 4 - Advanced

- Implement persistence with Spring Data
