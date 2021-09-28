# spring-data-rest-error-handling
### Um projeto Spring Data Rest com validação e tratamento de erros

O objetivo deste projeto é complementar as coisas necessárias para servir de um bom ponto de partida para a criação de um projeto real.

Acessar o BD por meio de http://localhost:9090/h2-console 
Usuário sa sem senha e JDBC URL jdbc:h2:mem:db

Acessar o Swagger por meio de http://localhost:9090/swagger-ui/index.html#/

Acessar o HAL Explore por meio de http://localhost:9090/api/explorer

```
POST /api/developers HTTP/1.1
Host: localhost:9090
accept: */*
Content-Type: application/json
Content-Length: 79

{
    "dob": "2021-09-28",
    "email": "xyx",
    "nickname": "nickname"
}
```

Resulta em:

```
{
    "errors": [
        {
            "entity": "Developer",
            "property": "email",
            "invalidValue": "xyx",
            "message": "invalid.field.value"
        }
    ]
}
```

Falta tratar erros de persistência e de conversão do payload para objeto Java.