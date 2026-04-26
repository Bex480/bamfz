# bamfz

Spring Boot backend (Java 25, Maven). Uses H2 in-memory for local dev, PostgreSQL in production. Same code runs against both — only config differs.

## Running

The app starts in the `dev` profile by default (H2 in-memory, zero setup):

```bash
./mvnw spring-boot:run
```

Then open the H2 console at <http://localhost:8080/h2-console> (JDBC URL: `jdbc:h2:mem:bamfz`, user `sa`, no password).

API docs (Swagger / OpenAPI):

- Swagger UI: <http://localhost:8080/swagger-ui/index.html>
- OpenAPI JSON: <http://localhost:8080/v3/api-docs>

To run against a local PostgreSQL, export the connection details and activate the `prod` profile:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/bamfz
export DB_USER=bamfz
export DB_PASSWORD=secret
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

## Database guidelines

To keep the same code working on both H2 and PostgreSQL, follow these portability rules:

- **No native SQL.** Never use `nativeQuery = true` in `@Query` — always write JPQL.
- **Avoid SQL reserved words** as column or table names. Words like `user`, `order`, `group`, `type`, `where`, `select` are reserved in one or both databases and need quoting that differs between them.
- **Use `GenerationType.IDENTITY`** for `@Id` fields, never `AUTO`. `AUTO` resolves to different strategies on H2 vs. PostgreSQL.
- **Use Java types in entities** (`Boolean`, `LocalDateTime`, `UUID`, etc.), not database-specific column definitions. Let Hibernate map them.
- **Stick with snake_case column names** — the JPA default. Don't override with `@Column(name = "...")` unless you have to.
