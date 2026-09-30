package com.marcossousadev.spring_projeto.infra;

import com.marcossousadev.spring_projeto.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// como criar um controllerAdvice?
// primeiramente eu uso o decorator ControllerAdvice, que também é chamada de anotação
// e tenho também que estender a ResponseEntityExceptionHandler
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    // depois eu crio ps métodos que vão ser cada uma das exceptions

    // retorno uma ResponseEntity e o tipo dessa entidade
    @ExceptionHandler(TaskNotFoundException.class)
    private ResponseEntity<String> taskNotFoundHandler(TaskNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task Not Found");
    }
}
