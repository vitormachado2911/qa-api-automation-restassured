# QA API Automation — RestAssured + JUnit (JSONPlaceholder)

Projeto de **automação de testes de API** desenvolvido em **Java** com **RestAssured** e **JUnit 5**, validando endpoints da API pública **JSONPlaceholder**.

O objetivo é demonstrar **boas práticas de engenharia de testes**, incluindo:

* Arquitetura limpa de testes
* Reutilização de configurações e especificações
* Validação de contrato com **JSON Schema**
* Logs claros de requisição e resposta
* Execução via **Maven** e integração com **CI**
* Versionamento profissional com **Git**
* Documentação de **testes manuais com evidências**

---

## 🚀 Stack Tecnológica

* **Java 8+**
* **Maven**
* **RestAssured**
* **JUnit 5**
* **Hamcrest**
* **JSON Schema Validator**
* **Postman + Newman** (execução alternativa)
* **Git & GitHub**

---

## 🎯 API Alvo

**Base URL**
[https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

**Endpoints cobertos**

* `GET /posts`
* `GET /posts/{id}`
* `GET /users`

---

## 🧱 Estrutura do Projeto

```
docs/                 → Documentação de testes manuais e estratégia
reports/              → Relatórios de execução (JUnit / Newman)

src/test/java
├─ base/        → BaseTest (configuração global)
├─ config/      → ApiConfig e SpecFactory (RequestSpecification)
├─ filters/     → PrettyLogFilter (logs visuais)
├─ models/      → POJOs (ex: Post)
└─ tests/       → Classes de teste (PostsTest, UsersTest)

src/test/resources
└─ schemas/     → JSON Schemas (post-schema.json)
```

---

# 🧪 Testes Manuais

Os **cenários manuais**, estratégia de teste, riscos e evidências estão documentados em:

📄 **[Documento de Testes Manuais](docs/Testes_Manuais_JSONPlaceholder.pdf)**

### Cobertura manual

* CT-01 — Listar posts
* CT-02 — Buscar post por ID válido
* CT-03 — Buscar post inexistente
* CT-04 — Listar usuários
* CT-05 — Validar formato JSON
* CT-06 — Tempo de resposta

### Objetivo dos testes manuais

Garantir:

* Reprodutibilidade por outros testadores
* Validação funcional básica da API
* Verificação de estrutura de resposta
* Identificação de riscos de ambiente mock

---

# ✅ Cenários Automatizados

## 1) Listar posts — `GET /posts`

**Validações**

* Status **200**
* Retorno com **100 posts**
* Campos obrigatórios presentes:

  * `userId`
  * `id`
  * `title`
  * `body`

---

## 2) Buscar post por ID — `GET /posts/{id}`

**Cenário executado**

```
/posts/1
```

**Validações**

* Status **200**
* Campo `id` igual a **1**
* Campos essenciais **não nulos**

---

## 3) Validação de contrato — JSON Schema

* Uso de **JSON Schema Validator (RestAssured)**
* Arquivo: `schemas/post-schema.json`

**Campos validados**

* `id` → inteiro
* `userId` → inteiro
* `title` → string
* `body` → string

---

## 4) Listar usuários — `GET /users`

**Validações**

* Status **200**
* Lista contendo **10 usuários**
* Campos básicos válidos:

  * `id`
  * `name`
  * `username`
  * `email` contendo `"@"`

---

# 🧾 Logs Visuais das Requisições

O projeto possui um **filtro customizado** que melhora a leitura das execuções no console.

**Exemplo**

```
GET https://jsonplaceholder.typicode.com/posts
→ 200 (204 ms)
```

Facilita a **análise rápida de falhas** durante a execução dos testes.

---

# ▶️ Como Executar

## Executar todos os testes (Maven)

```bash
mvn test
```

---

# 🔌 Execução Alternativa — Postman + Newman (PowerShell)

A collection Postman contém cenários equivalentes:

* `GET /posts`
* `GET /posts/{id}`

**Validações incluídas**

* Status code
* Campos obrigatórios
* Tipos de dados
* Valor do `id`

### Gerar relatório JUnit XML

```powershell
newman run "postman\JSONPlaceholder_API.postman_collection.json" `
  -e "postman\JSONPlaceholder_ENV.postman_environment.json" `
  -r junit `
  --reporter-junit-export "reports\newman\report.xml"
```

📄 Saída do relatório:

```
reports/newman/report.xml
```

### Observações importantes

* Execução estável utilizando **apenas o reporter `junit`**
* `cli` já é padrão do Newman
* Compatível com **PowerShell**

---

# 📊 Relatórios e Evidências

* **Relatório JUnit (Newman)**
  `reports/newman/report.xml`

* **Documento de Testes Manuais**
  `docs/Testes_Manuais_JSONPlaceholder.pdf`

* Compatível com:

  * GitHub Actions
  * GitLab CI
  * Jenkins
  * Azure DevOps

---

# 🧪 Boas Práticas Demonstradas

* Separação clara entre **configuração, modelos e testes**
* Reutilização de **RequestSpecification**
* Validação de **contrato de API**
* Logs legíveis para **debug rápido**
* Integração entre **testes manuais e automatizados**
* Projeto pronto para **integração contínua**

---

# 👨‍💻 Autor

**Vitor Machado**
QA Automation Engineer

* GitHub: [https://github.com/vitormachado2911](https://github.com/vitormachado2911)
* LinkedIn: [https://www.linkedin.com/in/vitormachadoprofissional/](https://www.linkedin.com/in/vitormachadoprofissional/)
* Email: [vh.machado44@outlook.com](mailto:vh.machado44@outlook.com)
