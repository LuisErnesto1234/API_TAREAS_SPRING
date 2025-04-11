package com.spring.udemy.gestor_de_tareas_personales.service;

import com.spring.udemy.gestor_de_tareas_personales.entity.Tarea;
import com.spring.udemy.gestor_de_tareas_personales.entity.enums.EstadoEnum;
import com.spring.udemy.gestor_de_tareas_personales.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> findAllTareas(){
        return Collections.unmodifiableList(tareaRepository.findAll());
    }

    public Optional<Tarea> findByIdTarea(Long id){
        return tareaRepository.findById(id);
    }

    public void deleteByIdTarea(Long id){
        tareaRepository.deleteById(id);
    }

    public Tarea addTarea(Tarea tarea){
        tarea.setFechaCreacion(LocalDate.now());
        tareaRepository.save(tarea);
        return tarea;
    }

    public List<Tarea> findAllEstadoTarea(EstadoEnum estadoEnum){
        return tareaRepository.findAllByEstadoEnum(estadoEnum);
    }

}
