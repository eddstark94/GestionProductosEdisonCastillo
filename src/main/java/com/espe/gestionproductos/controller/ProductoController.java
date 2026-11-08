package com.espe.gestionproductos.controller;

import com.espe.gestionproductos.model.Producto;
import com.espe.gestionproductos.service.ProductoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
//CLASE
public class ProductoController {
    private final ProductoService productoService;
    //inyeccion de dependencias mediante el constructor
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //metodo para consultar todos los productos
    @GetMapping("/api/productos")
    public List<Producto> listarProducto() {
        return productoService.listarProducto();
    }

    //metodo para consultar un producto por id
    @GetMapping("/api/productos/{id}")
    public Producto buscarProducto(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    //metodo para registrar un producto
    @PostMapping("/api/productos")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        productoService.agregarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }
    //metodo para eliminar un producto
    @DeleteMapping("/api/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}