package com.marcossousadev.spring_projeto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// o lombok cria códigos boilerplate de forma automática pra gente
@Getter
@Setter
public class Task {
    private int id;
    private String titulo;
    private String description;
    private boolean status;
}
