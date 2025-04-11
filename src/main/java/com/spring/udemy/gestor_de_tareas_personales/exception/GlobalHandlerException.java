package com.spring.udemy.gestor_de_tareas_personales.exception;

import com.spring.udemy.gestor_de_tareas_personales.exception.dto.CampoError;
import com.spring.udemy.gestor_de_tareas_personales.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalHandlerException {
    // Error 400 - Validaciones de campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> manejarValidaciones(MethodArgumentNotValidException ex) {
        List<CampoError> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new CampoError(err.getField(), err.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Error de validación",
                LocalDateTime.now(),
                errores
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Error 400 - Argumento inválido (tipo de dato incorrecto)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> argumentoInvalido(MethodArgumentTypeMismatchException ex) {
        String nombre = ex.getName();
        String valor = String.valueOf(ex.getValue());
        String tipoEsperado = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconocido";

        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Tipo de argumento inválido",
                LocalDateTime.now(),
                List.of(new CampoError(nombre, "Valor '" + valor + "' no es del tipo esperado (" + tipoEsperado + ")"))
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Error 404 - Ruta no encontrada
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDTO> rutaNoEncontrada(NoHandlerFoundException ex) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.NOT_FOUND.value(),
                "Ruta no encontrada",
                LocalDateTime.now(),
                List.of(new CampoError("ruta", "La URL '" + ex.getRequestURL() + "' no existe"))
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Error 405 - Método no permitido
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorDTO> metodoNoPermitido(HttpRequestMethodNotSupportedException ex) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "Método HTTP no permitido",
                LocalDateTime.now(),
                List.of(new CampoError("metodo", "Método '" + ex.getMethod() + "' no permitido para esta URL"))
        );
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // Error 400 - Falta de parámetro requerido
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> parametroFaltante(MissingServletRequestParameterException ex) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Parámetro faltante",
                LocalDateTime.now(),
                List.of(new CampoError(ex.getParameterName(), "El parámetro es requerido"))
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Error 500 - Cualquier otro error no controlado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> errorGeneral(Exception ex) {
        ErrorDTO error = new ErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocurrió un error inesperado en el servidor",
                LocalDateTime.now(),
                List.of(new CampoError("error", ex.getMessage()))
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
