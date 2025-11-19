## 📄 Projeto TaskMaster API: Gerenciamento de Tarefas com Spring Boot e MongoDB

Este projeto consiste em uma **API REST** completa para o gerenciamento de tarefas, utilizando a robustez do **Spring Boot** para o backend e a flexibilidade do **MongoDB** como banco de dados NoSQL.

-----

### 🌟 Visão Geral e Funcionalidades

A API permite a manipulação de tarefas através de todas as operações CRUD (Create, Read, Update, Delete).

| Operação | Detalhe |
| :--- | :--- |
| **Cadastro (POST)** | Cria uma nova tarefa. |
| **Consulta (GET)** | Lista todas as tarefas ou busca uma por ID. |
| **Atualização (PUT)** | Modifica uma tarefa existente. |
| **Exclusão (DELETE)** | Remove uma tarefa do sistema. |

#### Estrutura da Tarefa

Cada tarefa possui os seguintes atributos:

  * `titulo`: Título descritivo da tarefa.
  * `descricao`: Detalhes da tarefa.
  * `dataCriacao`: Data/Hora em que a tarefa foi registrada.
  * `dataConclusao`: Data/Hora prevista para a conclusão.
  * `status`: Enumeração indicando o progresso (PENDENTE, EM\_ANDAMENTO, CONCLUIDA).

-----

### 💻 Stack Técnica

  * **Linguagem:** Java 17
  * **Framework:** Spring Boot
      * `spring-boot-starter-web` (Para API REST)
      * `spring-boot-starter-data-mongodb` (Para persistência NoSQL)
  * **Banco de Dados:** MongoDB
  * **Gerenciador de Dependências:** Maven

### ⚙️ Instruções de Configuração e Execução

#### 1\. Configuração do MongoDB

É fundamental ajustar a string de conexão com o MongoDB no arquivo de propriedades:

  * **Caminho:** `src/main/resources/application.properties`
  * **Ajuste:** Configure as propriedades de conexão com seu servidor MongoDB local ou remoto.

#### 2\. Como Iniciar o Projeto

Você tem duas opções para rodar a aplicação:

**Opção A: Via Maven (Recomendado para desenvolvimento)**

```bash
mvn spring-boot:run
```

**Opção B: Via JAR (Após build)**

```bash
# Primeiro, crie o JAR: mvn package
java -jar target/tarefas-api-0.0.1-SNAPSHOT.jar
```

-----

### 🌐 Endpoints da API

A API é acessível na porta padrão `8080` (a menos que configurado de outra forma).

| Método HTTP | Rota | Função |
| :--- | :--- | :--- |
| **`GET`** | `/tarefas` | Listar todas as tarefas. |
| **`GET`** | `/tarefas/{id}` | Buscar tarefa pelo seu ID. |
| **`POST`** | `/tarefas` | Criar nova tarefa. |
| **`PUT`** | `/tarefas/{id}` | Atualizar tarefa existente. |
| **`DELETE`** | `/tarefas/{id}` | Excluir tarefa. |

#### Exemplo Prático: Criando uma Tarefa

Utilize o `curl` ou um cliente como Postman/Insomnia para testar a criação de um novo registro:

```bash
curl -X POST http://localhost:8080/tarefas -H "Content-Type: application/json" -d '{
  "titulo":"Estudar Spring Boot",
  "descricao":"Ler documentação e criar projeto",
  "dataConclusao":"2025-11-20T00:00:00Z",
  "status":"PENDENTE"
}'
```

-----
**Arthur Fernandes**
