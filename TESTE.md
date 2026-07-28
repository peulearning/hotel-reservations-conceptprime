
# Teste Técnico - Desenvolvedor Java | Plataforma de Integração de Reservas

## Objetivo

Desenvolver um serviço utilizando **Java 21** e **Spring Boot** responsável por integrar reservas de hotéis provenientes de parceiros externos.

O projeto deverá simular o funcionamento de um conector semelhante ao utilizado em integrações com OTAs (Omnibees, Booking, Expedia, etc.).

O foco principal é avaliar:

* Organização do projeto
* Arquitetura
* Qualidade do código
* Boas práticas
* Persistência
* Tratamento de erros
* Segurança
* Capacidade de modelagem

---

# Cenário

Um hotel recebe reservas através de parceiros externos.

Existem duas formas das reservas chegarem:

* Consulta periódica (Polling com uso de Schedule)
* Recebimento via API (Webhook)

O sistema deverá suportar ambas.

---

# Requisitos Funcionais

## 1. Polling de Reservas

Criar um processo automático que execute a cada **30 segundos** (ou tempo configurável).

Este processo deverá consumir um endpoint externo fictício.

Exemplo:

```
GET /mock/omnibees/reservations
```

O endpoint poderá retornar algo semelhante:

```json
[
  {
    "reservationId":"ABC123",
    "hotelId":1,
    "status":"NEW",
    "guest":"João",
    "checkIn":"2026-08-01",
    "checkOut":"2026-08-05"
  }
]
```

A aplicação deverá processar cada reserva recebida.


Pode criar um endpoint na propria aplicacao para simular as reservas.


---

## 2. Recebimento via API

Criar um endpoint REST:

```
POST /api/reservations
```

Este endpoint deverá receber uma reserva enviada por outro sistema.

---

## 3. Atualização

Caso uma reserva já exista, deverá ser atualizada.

Exemplo:

```
status = MODIFIED
```

Atualizar os dados existentes.

---

## 4. Cancelamento

Caso o status recebido seja

```
CANCELLED
```

A reserva deverá ser cancelada.

Não remover do banco.

Utilizar cancelamento lógico.

Exemplo

```
status = CANCELLED
cancelDate = now()
```

---

## 5. Evitar Duplicidade

Não pode existir duas reservas com o mesmo

```
reservationId
```

A aplicação deverá tratar isso adequadamente.

---

## 6. Banco de Dados

Persistir as reservas.

Pode ser utilizado:

* PostgreSQL
* H2
* SQLite

Fica a critério do candidato.

---

# Segurança

Proteger todos os endpoints REST utilizando

**Basic Authentication**

Usuário e senha podem ser definidos no application.yml.

---

# Modelo mínimo da Reserva

```text
Reservation

id

reservationId

hotelId

guestName

status

checkIn

checkOut

createdAt

updatedAt

cancelDate
```

---

# Endpoints Esperados

## Inserção

```
POST /api/reservations
```

---

## Consulta

```
GET /api/reservations
```

---

## Consulta por ID

```
GET /api/reservations/{reservationId}
```

---

## Cancelamento

```
DELETE /api/reservations/{reservationId}
```

---

# Requisitos Técnicos

Obrigatórios

* Java 21
* Spring Boot
* Maven
* Spring Data JPA
* Spring Security
* Bean Validation
* Banco Relacional
* Tratamento global de exceções
* Logs

---

# Diferenciais

Será considerado diferencial:

* Docker
* Docker Compose
* OpenAPI / Swagger
* Testes Unitários
* Testes de Integração
* Arquitetura em camadas
* DTOs
* Mapper (MapStruct)
* Flyway/Liquibase
* Observabilidade
* Actuator

---

# Regras de Negócio

## Inclusão

Se a reserva não existir

→ inserir.

---

## Alteração

Se existir

→ atualizar.

---

## Cancelamento

Se chegar

```
status = CANCELLED
```

→ cancelar.

---

## Idempotência

Caso a mesma reserva seja enviada duas vezes, o sistema não deverá criar registros duplicados.

---

## Validação

Todos os campos obrigatórios devem ser validados.

---

# Estrutura esperada

```
controller

service

repository

entity

dto

config

exception

scheduler

integration

security
```

---

# O que será avaliado

| Critério               | Peso  |
| ---------------------- | ----- |
| Organização do projeto | ⭐⭐⭐⭐⭐ |
| Arquitetura            | ⭐⭐⭐⭐⭐ |
| Código limpo           | ⭐⭐⭐⭐⭐ |
| Tratamento de exceções | ⭐⭐⭐⭐  |
| Persistência           | ⭐⭐⭐⭐  |
| Segurança              | ⭐⭐⭐   |
| Logs                   | ⭐⭐⭐   |
| Testes                 | ⭐⭐⭐⭐  |
| Boas práticas Spring   | ⭐⭐⭐⭐⭐ |
| Modelagem              | ⭐⭐⭐⭐⭐ |

---

# Entrega

Disponibilizar um repositório Git contendo:

* Código fonte
* README explicando como executar
* Docker Compose (opcional)
* Collection do Postman ou arquivo OpenAPI

---

# Desafio Extra (Opcional)

Implemente suporte a **múltiplos hotéis e parceiros**, simulando um cenário mais próximo de produção:

* Criar uma tabela de configuração contendo hotéis e integrações ativas.
* Cada hotel pode possuir um ou mais parceiros (ex.: Omnibees, Booking, Expedia).
* O processo de polling deve buscar apenas os parceiros ativos.
* Definir uma interface, por exemplo `ReservationIntegration`, e implementar uma classe para cada parceiro (`OmnibeesIntegration`, `BookingIntegration`, etc.), permitindo adicionar novos parceiros sem alterar a lógica principal (princípio Open/Closed).
* Cada integração deve ser executada de forma independente, registrando logs e tratando falhas sem interromper as demais.
* Caso uma integração falhe, as outras devem continuar sendo processadas.

---

