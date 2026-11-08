package com.espe.gestionproductos.exception;

public class ProductoNoEncontradoException extends RuntimeException{
    public ProductoNoEncontradoException(Long id){
        super("no se encontro producto con ID: " + id);
    }

}
