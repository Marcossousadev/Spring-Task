package com.marcossousadev.spring_projeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// custom exception que são exceções customizadas da nossa aplicação
public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(){ super("Task não encontrada!");}

    public TaskNotFoundException(String message) { super(message); }
}
