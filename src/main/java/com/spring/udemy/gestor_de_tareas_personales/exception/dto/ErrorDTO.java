package com.spring.udemy.gestor_de_tareas_personales.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDTO {
    private int status;
    private String mensaje;
    private LocalDateTime localDateTime;
    private List<CampoError> campoErrors;
}
