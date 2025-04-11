package com.spring.udemy.gestor_de_tareas_personales.controller;

import com.spring.udemy.gestor_de_tareas_personales.entity.Tarea;
import com.spring.udemy.gestor_de_tareas_personales.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/tarea")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @Operation(summary = "Listar todas las tareas", description = "Retorna una lista de tareas")
    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTareas(){
        return ResponseEntity.ok(tareaService.findAllTareas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscarTareaPorID(@PathVariable Long id){
        return tareaService.findByIdTarea(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada!"));
    }

    @Operation(method = "POST", description = "Agrega una nueva tarea", summary = "Agregar Tarea", tags = {"POST"})
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody @Valid Tarea tarea){
        return ResponseEntity.ok(tareaService.addTarea(tarea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTareaPorId(@PathVariable Long id){
        tareaService.deleteByIdTarea(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> editarTarea(@PathVariable Long id, @RequestBody @Valid Tarea tarea){
        return tareaService.findByIdTarea(id).map(t -> {
            t.setTitulo(tarea.getTitulo());
            t.setDescripcion(tarea.getDescripcion());
            t.setFechaVencimiento(tarea.getFechaVencimiento());
            t.setEstadoEnum(tarea.getEstadoEnum());
            t.setPrioridadEnum(tarea.getPrioridadEnum());
            return ResponseEntity.ok(tareaService.addTarea(t));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
