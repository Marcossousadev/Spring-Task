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

# Tratamento de erros
    
 - Existe duas formas que são perigosas de tratar erros no Spring:
   - Tratar com Spring padrão, expõem stack strace;
   - Tratar no controller, código repetitivo;
 - Por isso utilizamos a custom exception, que são exceções customizadas para nossa lógica de negócio.

 # Criando uma custom exception:

    
```java
   public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(){
        super("Evento não existe!");
    }
    public EventNotFoundException(String message) {
        super(message);
    }
  }
```

Mas ainda apenas isso não resolve, porque ainda expõem a stack strace, precisamos criar um ControllerAdvice, onde vai centralizar toda esse nosso tratamento de erro dos nossos controller, cada método é o tratamento de uma exceção!
Ao invés de colocarmos um try/catch em cada endpoint da aplicação,
criamos um ControllerAdvice que vai ficar responsável pelos tratamentos de erro desse endpoint!


# Criando o ControllerAdvice
``` java
    @ControllerAdvice
    public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    
        @ExceptionHandler(EventNotFoundException.class)
        private ResponseEntity<String> eventNotFoundHandler(EventNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
       
    }
    
```    



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
