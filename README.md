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

Gostaria de adicionar tratamento de erros de associação entre entidades (erros de integridade referencial).

Gostaria também de adicionar tratamento de erros de tentativa de remover uma linha de uma tabela que possua associação com uma linha de outra tabela.

Resumidamente, a ideia é sempre ser capaz de mostrar erros de forma amigável.

O mapeamento de erros para mensagens localizadas também estar por fazer.

Agradeço as contribuições que vocês possam em fornecer!
