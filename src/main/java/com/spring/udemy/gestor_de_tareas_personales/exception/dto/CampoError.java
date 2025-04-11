package com.spring.udemy.gestor_de_tareas_personales.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CampoError {
    private String campo;
    private String mensaje;
}
