package com.spring.udemy.gestor_de_tareas_personales;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestor de Tareas",
                version = "1.0",
                description = "API REST para gestionar tareas personales",
                summary = "Una API de prueba para poner en practica todo lo aprendido, esta API contiene manejo de base de datos y manejo de excepciones, tambien la inyección de dependencias"
        )
)

@SpringBootApplication
public class GestorTareasPersonalesToDoListAvanzadaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorTareasPersonalesToDoListAvanzadaApplication.class, args);
    }

}
