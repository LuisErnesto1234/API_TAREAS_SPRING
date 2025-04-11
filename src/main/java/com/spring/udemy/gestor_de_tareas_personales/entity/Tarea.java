package com.spring.udemy.gestor_de_tareas_personales.entity;

import com.spring.udemy.gestor_de_tareas_personales.entity.enums.EstadoEnum;
import com.spring.udemy.gestor_de_tareas_personales.entity.enums.PrioridadEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarea")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 3, message = "El titulo debe contener 3 letras como minimo!")
    private String titulo;
    private String descripcion;
    @Column(name = "fecha_vencimiento")
    @NotNull(message = "La fecha de vencimiento es obligatorio!")
    private LocalDate fechaVencimiento;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado no puede estar vacio!!")
    private EstadoEnum estadoEnum;

    @Column(name = "prioridad")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "La prioridad no puede estar vacia!!")
    private PrioridadEnum prioridadEnum;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

}
