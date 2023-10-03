<h1 align="center">
  Wirecard Backend Challenge
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Linkedin&message=@tgribeiro&color=8257E5&labelColor=000000" alt="@tgribeiro" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

A simple application to provide an API for payment to our customers and a checkout for who don't want to integrate with our API.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring Data + R2DBC](https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Slugify](https://github.com/slugify/slugify)
- *[Httpie](https://httpie.io/)*
- *[Swagger](https://swagger.io/)*

## Práticas adotadas

- SOLID
- Testes automatizados
- Consultas com filtros dinâmicos usando o Query By Example
- API reativa na web e na camada de banco
- Uso de DTOs para a API
- Injeção de Dependências
- Geração automática do Swagger com a OpenAPI 3
- Geração de slugs automática com o Slugify
- Auditoria sobre criação e atualização da entidade

## Level 1: The API

We need to create a new API to process payments for our customers.
That been said, we need:

#### 1. An endpoint to create payments
- The API needs to accept two payment methods: Credit Card and Boleto.
- When the payment method is boleto, we only need to return the boleto's number in our response.
- When the method is card, we need to return if it was successful or not *(please don't worry about processing the payment, just mock the answers)*.
- The API must receive the information of the buyer, customer and payment. The information needed is the following:
```
Client:
 - ID

Buyer:
 - Name
 - Email
 - CPF

Payment:
 - Amount
 - Type
 - Card (when the payment type is credit card)

Card:
 - Card holder name
 - Card number
 - Card expiration date
 - Card CVV (Number behind the card)

```

#### 2. An endpoint to check the payment status
- The API needs to return all the information about the payment, as well as the status of that payment.

#### 3. Unit Tests
Unit tests are required

## Level 2: The Checkout

We need a way to use the API: It could be a simple checkout page (or a simple order completion page, you don't need to care about design or layout), some `curl`'s examples or `Postman`'s documentation.

This step is focused on seeing how you integrate APIs.

In this checkout, we need:
- To send the buyer information with the payment method.
- To validate if the card is valid and who is the card issuer.
- To simulate a form of identification of the buyer that will be sent to the API.
- To return if the transaction was successful or not.
- To persist and consume the data effectively for this test.

## How to run

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service/target/place-service-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name place-service -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- POST /places
```
http POST :8080/places name="Place" state="State"

HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-04-20T19:00:07.241632",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "updatedAt": "2023-04-20T19:00:07.241632"
}
```

- GET /places/{id}
```
http :8080/places/1
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "Place",
    "slug": "place",
    "state": "State",
    "updatedAt": "2023-06-07T14:45:39.693689"
} 
```

- GET /places?name=?
```
http :8080/places name==PLACE
HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "createdAt": "2023-06-07T14:45:39.693689",
        "name": "Place",
        "slug": "place",
        "state": "State",
        "updatedAt": "2023-06-07T14:45:39.693689"
    }
]
```

- PATCH /places/{id}
```
http PATCH :8080/places/1 name='New Name' state='New State'
HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "New Name",
    "slug": "new-name",
    "state": "New State",
    "updatedAt": "2023-06-07T14:53:21.671129345"
}
```
## Related links
- [Link to the challenge](https://github.com/wirecardBrasil/challenge/tree/master/backend)
- [Sample project](https://github.com/wirecardBrasil/payment-api)

