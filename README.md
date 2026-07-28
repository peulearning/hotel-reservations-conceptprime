# Hotel Reservation Integration

## Tecnologias

- Java 21 ✔️
- Spring Boot ✔️
- PostgreSQL ✔️
- Spring Data JPA ✔️
- Spring Security ✔️
- MapStruct ✔️
- Maven ✔️

## Arquitetura em camadas

controller ✔️
service ✔️
repository ✔️
entity ✔️
dto ✔️
mapper ✔️
config ✔️
exception ✔️
scheduler ✔️
integration ✔️
security ✔️

## Como executar
```
1. Subir PostgreSQL

2. Configurar application.yml ( application.properties )

3. mvn clean install

4. mvn spring-boot:run
```

## Endpoints
```
GET /api/reservations

GET /api/reservations/{id}

POST /api/reservations

DELETE /api/reservations/{id}

GET /mock/omnibees/reservations

GET /actuator/health
```

## Fluxo
```
Scheduler

↓

Mock Omnibees

↓

ReservationService

↓

Banco PostgreSQL

↓

Consulta via API
```

## Funcionalidades implementadas

✔ Polling

✔ Webhook

✔ Atualização

✔ Cancelamento lógico

✔ Idempotência

✔ Validação

✔ Logs

✔ Basic Authentication

✔ Actuator

---

Desenvolvido por Pedro Henrique com ☕  