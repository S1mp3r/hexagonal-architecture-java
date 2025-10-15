# Ports / Adapters POC

A small Java project built with **Spring Boot** and **Apache Kafka** to learn and apply **Hexagonal Architecture** concepts.

---

## Architecture Overview

The system is designed around **Hexagonal Architecture (Ports and Adapters)**.

- **Application layer:**
  - **Core layer:** Core business logic.
  - **Ports layer:** Ports and services that orchestrate the business logic.
- **Infrastructure layer:** Adapters for Kafka, persistence, and configuration.

---

## Workflow

1. **Customer Service**

   - Exposes a REST API (`/customers`) supporting full **CRUD operations**.
   - When a new customer is created, a **Kafka message** containing the **CPF** is published to the topic `cpf-validation-topic`.

2. **CpfValidator Service**

   - Subscribes to `cpf-validation-topic`.
   - Validates whether the CPF is valid using the Brazilian CPF validation algorithm.
   - Creates a `CustomerMessage` object with:
     - Customer details, such as id, name, cpf, zipCode and etc...
     - A new attribute: `isValidCpf`
   - Publishes this enriched object to the `cpf-validated-topic`.

3. **Customer Service - Consumer Side**
   - Listens to the `cpf-validated-topic`.
   - Receives the `CustomerMessage` object.
   - Updates the corresponding customer in the database with the CPF validation result.

Run the main application to see with more details:

- `http://localhost:8080/swagger-ui/index.html`

---

## Project Structure

```bash
src/main/java/com/rafael/hexagonal/architecture
├── application
│   ├── core
│   │   ├── domain
│   │   └── usecase
│   └── ports
│       ├── in
│       └── out
│
├── adapters
│   ├── in
│   │   ├── controller
│   │   └── consumer
│   └── out
│       ├── client
│       └── repository
│
└── config
    └── kafka
```
