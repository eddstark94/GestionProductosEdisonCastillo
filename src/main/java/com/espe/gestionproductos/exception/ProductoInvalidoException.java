package com.espe.gestionproductos.exception;


public class ProductoInvalidoException extends RuntimeException{
    public ProductoInvalidoException(String mensaje){
        super(mensaje);
    }
}
