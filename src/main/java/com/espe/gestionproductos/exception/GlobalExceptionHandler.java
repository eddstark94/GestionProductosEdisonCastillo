package com.espe.gestionproductos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //manejamos errores cuando un producto no existe
    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<String> manejarProductoNoEncontrado(ProductoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //manejamos errores cuando los datos del producto son invalidos
    @ExceptionHandler(ProductoInvalidoException.class)
    public ResponseEntity<String> manejarProductoInvalido(ProductoInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
