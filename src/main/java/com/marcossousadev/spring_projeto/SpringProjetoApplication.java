package com.marcossousadev.spring_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// decorator inicializador do meu projeto spring
// utiliza três decorator por baixo
// @Configuration, aprova métodos com Bean
// @EnableAutoConfiguration, atuo configuração
// @ComponentScan, escanei toda a aplicação e faz a injeção de dependências
@SpringBootApplication
public class SpringProjetoApplication {
	// método inicializador da aplicação
	public static void main(String[] args) {
		SpringApplication.run(SpringProjetoApplication.class, args);
	}
}
