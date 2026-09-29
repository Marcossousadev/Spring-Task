# 📋 API de Gerenciamento de Tarefas

Projeto desenvolvido em **Java com Spring Boot** para praticar a criação de uma **API REST** para gerenciamento de tarefas.

A aplicação permite criar, consultar, filtrar, atualizar e excluir tarefas. Atualmente, os dados são armazenados em memória utilizando uma `List`.

---

## 🚀 Funcionalidades

- ✅ Criar tarefas
- 🔎 Buscar tarefa por ID
- 📋 Listar todas as tarefas
- 🔍 Filtrar tarefas pelo título
- 🗑️ Excluir tarefas
- ☑️ Atualizar o status da tarefa
- ✏️ Atualizar dados da tarefa
- 🆔 Geração automática de IDs
- ⚠️ Tratamento básico de exceções

---

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Maven
- Lombok
- IntelliJ IDEA

---

## 📁 Estrutura do projeto

```text
src
└── main
    ├── java
    │   └── com.marcossousadev.spring_projeto
    │       ├── controller
    │       │   └── TaskController.java
    │       │
    │       ├── domain
    │       │   └── Task.java
    │       │
    │       ├── service
    │       │   └── TaskService.java
    │       │
    │       └── SpringProjetoApplication.java
    │
    └── resources
        └── application.properties
