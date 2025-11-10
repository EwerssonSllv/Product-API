# Product Study Project

Simple **Spring Boot** project used as a *playground* to study and practice software engineering concepts: DTOs, tests (unit and integration), security (JWT and OAuth2), best practices, architecture, CI/CD, Docker, and more.

> This repository contains a minimalist REST API to manage products (`Product`) with examples of **entity**, **service**, **repository**, **controller**, and **DTO** usage.

---

## Project Goals

1. Serve as a **laboratory** to learn and experiment with advanced techniques and best practices.
2. Provide a small and stable set of endpoints for adding tests, authentication, authorization, logging, monitoring, etc.
3. Evolve gradually: start simple and progressively add features (JWT, OAuth2, MapStruct, Testcontainers, CI/CD, etc.).

---

## Current Structure (Summary)

* `Product` — JPA entity (`products` table)
* `ProductRepository` — `JpaRepository<Product, Long>`
* `ProductService` — business logic and transformation to `ProductDTO`
* `ProductController` — REST endpoints
* `ProductDTO` — output DTO (used to control what is exposed by the API)

### Current Endpoints

* `POST /product` — creates a new product (currently receives a `Product` directly in the request body)
* `GET /product` — lists products (returns `List<ProductDTO>`)
* `GET /product/{id}` — gets a product by id (returns `Optional<ProductDTO>`)
* `GET /product/price/{smaller}/{bigger` — obtains products between two values.
> Note: In the current state some points can be improved (validation, proper HTTP status codes, error handling, using an input DTO for creation, etc.) — see the "Planned Improvements" section.

---

## Why Use DTOs Here

* *Control what is exposed:* the output DTO allows you to return only the public fields you want (avoid exposing sensitive or internal fields).
* *Different views/versions:* easy to create `ProductSummaryDTO`, `ProductDetailDTO`, etc.
* *Decouple API from database modeling:* entity changes do not force API changes.


## Planned Improvements (Backlog)

### High Priority

* ✔ **Input DTOs** for creation/update (`CreateProductDTO`, `UpdateProductDTO`) and validation using `@Valid`, `@NotNull`, `@Positive`, etc.
* ✔ **Proper Responses:** return `ResponseEntity` with correct HTTP statuses (201 Created, 404 Not Found, 400 Bad Request).
* ✔ **Exceptions**
* ✔ **DTO ↔ Entity Mapping:** use MapStruct or a model mapper instead of manual constructors.
* ✔ **Unit Tests:** mock `ProductRepository` and test `ProductService`.

### Medium Priority

* **Authentication/Authorization:**

* ✔ **JWT (stateless)** — protect endpoints such as product creation
*   **OAuth2 (e.g., external provider integration)** — study flows and scopes
* ✔ **Documentation:** Swagger / OpenAPI
* **Database validations and constraints** (unique, length, not null)
* **Structured logging** with request correlation (MDC)

### Low / Exploratory

* **Rate limiting** and abuse protection
* **Metrics and observability:** Prometheus + Grafana
* **Tracing:** Jaeger / OpenTelemetry
* **Quality gates:** SonarQube and test coverage
* **CI/CD:** GitHub Actions for build, tests, analysis, and deploy to staging
* **Docker & docker-compose:** containerize the app + PostgreSQL

---

## Suggested Patterns and Practices

* ✔ **Clear separation of layers:** Controller → Service → Repository
* ✔ **Separate DTOs:** input vs. output DTOs
* ✔ **Immutability in DTOs
* **Test critical units first** (service) and then integration
* **Code style and linting:** adopt a formatter/Checkstyle
* **Branching strategy:** protected `main`; feature branches; PRs with green CI

---

## Example Tasks to Practice

* Implement input and output DTOs; update controller to use `ResponseEntity`.
* Add validation with `@Valid` and tests covering validation errors.
* Write unit tests for `ProductService` using Mockito.
* Create integration tests with Testcontainers running a real PostgreSQL instance.
* Implement JWT authentication: `/auth/login` returning token; secure `POST /product`.
* Add Swagger UI and configure API documentation
