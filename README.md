# Checkpoint 4 - API de Tarefas

API REST em **Spring Boot** para gerenciamento de tarefas com banco **MySQL**.

---

## 🛠 Desenvolvido por

* **Paulo Henrique** | RM 552444
* **Pedro Cavariani** | RM 551380

---
## 📋 Pré-requisitos

* Docker instalado
* Docker Compose instalado (para execução com múltiplos containers)

---

## ✅ Testes

Os testes unitários rodam com H2 em memória (`src/test/resources/application.properties`).  
CI (Continuous Integration) é executado automaticamente no GitHub Actions ao dar push nas branches: `develop`, `feature` e `hotfix`.  

## ⚡ Continuous Delivery e Release

### Continuous Delivery (CD)

Ao criar um pull request para a branch `main`, o GitHub Actions automaticamente:

- Constrói a aplicação
- Empacota a imagem Docker
- Publica no Docker Hub

### Release Automática

Ao push na branch `main`, o GitHub Actions gera automaticamente:

- Documentação da versão (Javadoc)
- Tag de Release no GitHub
- Mensagem automática descrevendo a versão


## 🚀 Executando via Docker Hub

1. **Rodar o container MySQL:**

```
docker run -d --name cp4-mysql \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=cp4 \
-e MYSQL_USER=cp4 \
-e MYSQL_PASSWORD=cp4 \
-p 3307:3306 mysql:8.4
```

2. **Rodar o container da API:**

```
docker run -d --name cp4-api --link cp4-mysql:db \
-e SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/cp4 \
-e SPRING_DATASOURCE_USERNAME=cp4 \
-e SPRING_DATASOURCE_PASSWORD=cp4 \
-p 8080:8080 paulo20lima/checkpoint4:1.0
```

---

## 🐳 Executando via Docker Compose

1. **Clonar o repositório:**

```
git clone https://github.com/paulo20lima/checkpoint4.git
cd checkpoint4
```

2. **Subir os containers:**

```
docker-compose up --build
```

3. **Parar os containers:**

```
docker-compose down
```


---

## 🔗 Rotas da API

Todos os endpoints estão sob `/tarefas`:

* **GET /tarefas**
  Retorna a lista de todas as tarefas.

* **GET /tarefas/{id}**
  Retorna uma tarefa específica pelo ID.

* **POST /tarefas**
  Cria uma nova tarefa. O corpo da requisição deve conter `titulo`, `descricao` e `concluida`.

* **PUT /tarefas/{id}**
  Atualiza uma tarefa existente pelo ID. O corpo da requisição deve conter `titulo`, `descricao` e `concluida`.

* **DELETE /tarefas/{id}**
  Deleta uma tarefa pelo ID.

---

## 📖 Acesso ao Swagger

Acessar: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
Permite testar todos os endpoints da API diretamente pelo navegador.
