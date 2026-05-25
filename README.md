# Spring Cloud Microservices Demo

Учебный проект на Spring Boot / Spring Cloud с базовой микросервисной архитектурой.

Проект демонстрирует: 
регистрацию сервисов в Eureka;
маршрутизацию запросов через API Gateway;
разделение приложения на несколько микросервисов;
взаимодействие сервисов через REST API.

## Состав проекта

- `eureka-server` — service discovery
- `api-gateway` — единая точка входа и маршрутизация запросов
- `order-service` — сервис заказов
- `payment-service` — сервис платежей

## Стек

- Java 21
- Spring Boot
- Spring Cloud
- Eureka Server / Eureka Client
- Spring Cloud Gateway
- REST API

## Запуск

Сервисы запускаются отдельно, в следующем порядке:

1. `eureka-server`
2. `api-gateway`
3. `order-service`
4. `payment-service`

Для каждого сервиса:

```bash
./mvnw spring-boot:run

или, если используется Gradle:

./gradlew bootRun
Порты
Eureka Server: http://localhost:8761
API Gateway: http://localhost:8080
Order Service: http://localhost:8081
Payment Service: http://localhost:8082
Примеры запросов через Gateway
GET http://localhost:8080/orders
GET http://localhost:8080/payments

