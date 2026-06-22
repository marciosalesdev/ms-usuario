# ms-usuario

> Microsserviço de gerenciamento de usuários com autenticação JWT — Spring Boot 3 + Gradle + PostgreSQL.

---

## Sobre o projeto

O **ms-usuario** é um microsserviço responsável pelo ciclo completo de gestão de usuários: cadastro, autenticação e autorização. Construído com Spring Security e JWT, serve como base de autenticação para arquiteturas de microsserviços, expondo endpoints REST para integração com outros serviços.

Este projeto faz parte de um ecossistema de microsserviços e foi desenvolvido utilizando **Gradle** como ferramenta de build e **GitHub Actions** para integração contínua.

---

## Funcionalidades

- Cadastro de usuários com validação de dados
- Autenticação via JWT (JSON Web Token)
- Controle de acesso baseado em roles (Spring Security)
- Endpoints REST para consulta e atualização de perfil
- Integração contínua configurada com GitHub Actions

---

## Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 3.5 |
| Segurança | Spring Security + JWT (jjwt 0.13) |
| Persistência | Spring Data JPA + Hibernate |
| Banco de dados | PostgreSQL |
| Build | Gradle |
| CI/CD | GitHub Actions |
| Utilitários | Lombok |
| Testes | JUnit 5 + Spring Security Test |

---

## Arquitetura

```
ms-usuario/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/marciosalesdev/
│       │       ├── controller/   # Endpoints REST
│       │       ├── service/      # Regras de negócio
│       │       ├── repository/   # Acesso a dados (JPA)
│       │       ├── model/        # Entidades
│       │       ├── dto/          # Objetos de transferência
│       │       └── security/     # Configuração JWT e Spring Security
│       └── resources/
│           └── application.properties
└── build.gradle
```

---

## Como executar

### Pré-requisitos

- Java 21+
- Gradle 8+
- PostgreSQL 14+

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/marciosalesdev/ms-usuario.git
cd ms-usuario
```

2. Configure o banco de dados no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ms_usuario
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

jwt.secret=sua_chave_secreta
jwt.expiration=86400000
```

3. Execute a aplicação:
```bash
./gradlew bootRun
```

---

## Endpoints principais

| Método | Rota                | Descrição                | Auth |
|---|---------------------|--------------------------|---|
| POST | `/auth/register`    | Cadastro de usuário      | Não |
| POST | `/auth/login`       | Login e geração de token | Não |
| GET | `/usuarios/{email}` | Buscar usuario por email | JWT |
| PUT | `/usuarios/{id}`    | Atualização de perfil    | JWT |
| Método | Rota | Descrição | Auth |


---

## CI/CD

O projeto possui workflow de integração contínua configurado em `.github/workflows/`, com execução automática de build e testes a cada push.

---

## Autor

**Marcio Serra Sales**
- LinkedIn: [linkedin.com/in/marciosalesdev](https://www.linkedin.com/in/marciosalesdev)
- GitHub: [github.com/marciosalesdev](https://github.com/marciosalesdev)
