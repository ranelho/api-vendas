# Sistema de controle de matriculas de Auto Escola

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/iuricode/README-template?style=for-the-badge)

## ✔️ Técnicas e tecnologias utilizadas

- ``Java``
- ``Spring Boot``
- ``Maven``
- ``JPA``
- ``Lombok``
- ``PostgreSQL``
- ``IntelliJ IDEA``
- ``Swagger``
- ``Postman``
- ``DBeaver``
- ``Git``
- ``GitHub``

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [X] Cliente
  - [ ] Contato
- [ ] Produto
  
# Banco de Dados


## Trechos de código

### Swagger
http://localhost:8080/vendas/api/public/swagger-ui/index.html#/

### application.yml

```
spring:
  profiles:
    active: ${SPRING_PROFILES_ACTIVE:dev}
server:
  servlet:
    context-path: /vendas/api

springdoc:
  swagger-ui:
    path: /public/swagger
```

### application-prod.yml
```
spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: ${DB_HOST_PROD}
    username: ${DB_USERNAME_PROD}
    password: ${DB_PASSWORD_PROD}
  jpa:
    generate-ddl: true
    properties:
      hibernate:
        ddl-auto: update
        show_sql: true
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
    open-in-view: false
```

# Autores

| [<img src="perfil2.jpg" width=115><br><sub>Ranelho Lacerda</sub>](https://github.com/ranelho) | [<img src="john.jpeg" width=115><br><sub>Maabia Oliveira Ferreira</sub>](https://github.com/JohnEverton-Dev) |
|:---------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------:|

[⬆ Voltar ao topo](https://github.com/ranelho/api-vendas)<br>