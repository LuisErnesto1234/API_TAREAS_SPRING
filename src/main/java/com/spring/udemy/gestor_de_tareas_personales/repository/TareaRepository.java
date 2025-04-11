package com.spring.udemy.gestor_de_tareas_personales.repository;

import com.spring.udemy.gestor_de_tareas_personales.entity.Tarea;
import com.spring.udemy.gestor_de_tareas_personales.entity.enums.EstadoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findAllByEstadoEnum (EstadoEnum estadoEnum);

}
