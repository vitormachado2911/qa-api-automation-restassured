# QA API Automation — RestAssured + JUnit (JSONPlaceholder)

Projeto de **automação de testes de API** desenvolvido em **Java** utilizando **RestAssured** e **JUnit 5**, validando endpoints da API pública **JSONPlaceholder**.

Este projeto demonstra boas práticas de:

- Organização de testes
- Reutilização de código
- Validação de contrato (JSON Schema)
- Logs visuais de requisição/resposta
- Versionamento com Git

---

## 🚀 Tecnologias utilizadas

- Java 8+
- Maven
- RestAssured
- JUnit 5
- Hamcrest
- JSON Schema Validator (RestAssured)
- Git & GitHub

---

## 🎯 API alvo

Base URL: https://jsonplaceholder.typicode.com


Endpoints automatizados:

- `GET /posts`
- `GET /posts/{id}`
- `GET /users`

---

## 🧱 Estrutura do projeto

src/test/java
├─ base/ → BaseTest (configuração global)
├─ config/ → ApiConfig e SpecFactory (RequestSpecification)
├─ filters/ → PrettyLogFilter (logs visuais)
├─ models/ → POJOs (ex: Post)
└─ tests/ → Classes de teste (PostsTest, UsersTest)

src/test/resources
└─ schemas/ → JSON Schemas (post-schema.json)


---

## ✅ Cenários automatizados

### 1) Listar posts — `GET /posts`

Validações:

- Status **200**
- Retorno com **100 posts**
- Campos obrigatórios:
    - `userId`
    - `id`
    - `title`
    - `body`

---

### 2) Buscar post por ID — `GET /posts/{id}`

Teste realizado:

/posts/1

Validações:

- Status **200**
- Campo `id` igual a **1**
- Campos essenciais **não nulos**

---

### 3) Validação de contrato (JSON Schema)

- Uso de **JSON Schema Validator**
- Arquivo: schemas/post-schema.json


Valida:

- `id` → inteiro
- `userId` → inteiro
- `title` → string
- `body` → string

---

### 4) Listar usuários — `GET /users`

Validações:

- Status **200**
- Lista com **10 usuários**
- Campos básicos válidos:
    - `id`
    - `name`
    - `username`
    - `email` contendo `"@"`

---

## 🧾 Logs visuais das requisições

O projeto possui filtro customizado para facilitar a leitura no console.

Exemplo:

✅ GET https://jsonplaceholder.typicode.com/posts
-> 200 (204 ms)



Isso ajuda na **análise rápida de falhas** durante execução dos testes.

---

## ▶️ Como executar os testes

### Executar todos os testes

```bash
mvn test
```

---

## 👨‍💻 Autor

**Vitor Machado**  
QA Automation Engineer

- GitHub: https://github.com/vitormachado2911
- LinkedIn: https://www.linkedin.com/in/vitormachadoprofissional/
- Email: vh.machado44@outlook.com