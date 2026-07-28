# Hotel Reservation Integration 🏨

## Sobre o projeto 🔎

Este projeto implementa um serviço de integração de reservas de hotéis utilizando Java 21 e Spring Boot.

A aplicação simula o funcionamento de conectores utilizados por plataformas como Omnibees, Booking e Expedia, permitindo o recebimento de reservas por Polling e por Webhook.

---

## Tecnologias 🧑‍💻

- Java 21 ✅
- Spring Boot 4 ✅
- Spring Data JPA ✅
- PostgreSQL ✅
- Spring Security ✅
- MapStruct ✅
- Bean Validation ✅
- Maven ✅
- Spring Scheduler ✅
- Actuator ✅
- OpenAPI / Swagger ✅

---

## Arquitetura 📁

```
controller
service
repository
entity
dto
mapper
config
security
exception
scheduler
integration
```

O projeto segue arquitetura em camadas, separando responsabilidades entre API, regras de negócio, persistência e integração. ✨

---

## Funcionalidades 🙌

### Polling ⏳

Um Scheduler executa periodicamente uma consulta ao parceiro externo (simulado por um mock interno) para buscar novas reservas.

```
Scheduler
        ↓
Mock Omnibees
        ↓
ReservationService
        ↓
PostgreSQL
```

---

### Webhook 📫

Também é possível receber reservas diretamente pela API:

```
POST /api/reservations
```

---

### Atualização 🔄️

Caso uma reserva já exista (mesmo `reservationId`), seus dados são atualizados.

---

### Cancelamento ❌

Quando o status recebido é `CANCELLED`, a reserva é cancelada logicamente.

Os dados permanecem armazenados no banco de dados.

---

### Idempotência 🆔

A aplicação garante que não existam reservas duplicadas utilizando o campo `reservationId`.

---

## Banco de dados 💱

Foi utilizado PostgreSQL com Spring Data JPA.

---

## Segurança 🔏

Os endpoints REST são protegidos com Basic Authentication.

O endpoint utilizado para simulação da integração (`/mock/**`) permanece liberado para permitir que o Scheduler realize as consultas automaticamente.

---

## Endpoints 👾

### Reservas 🏞️

```
POST   /api/reservations
GET    /api/reservations
GET    /api/reservations/{reservationId}
DELETE /api/reservations/{reservationId}
```

### Mock 🧱

```
GET /mock/omnibees/reservations
```

### Monitoramento 🖥️

```
GET /actuator/health
```

### Swagger 📃

```
http://localhost:8080/swagger-ui/index.html
```

---

## Como executar 🤔

```bash
mvn clean install
```

Depois:

```bash
mvn spring-boot:run
```

---

## Fluxo da aplicação ⛲

```
Parceiro (Omnibees)

↓

Mock

↓

Scheduler

↓

ReservationService

↓

PostgreSQL

↓

API REST
```

---

## Diferenciais implementados 🫰

- Arquitetura em camadas
- DTOs
- MapStruct
- Tratamento global de exceções
- Scheduler
- Actuator
- OpenAPI
- Bean Validation
- Basic Authentication
- Logs
- Idempotência

---

Desenvolvido com ☕ por Pedro Henrique 🧑‍💻.