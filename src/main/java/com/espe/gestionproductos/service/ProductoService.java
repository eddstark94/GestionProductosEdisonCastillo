package com.espe.gestionproductos.service;
import com.espe.gestionproductos.model.Producto;
import com.espe.gestionproductos.exception.ProductoInvalidoException;
import com.espe.gestionproductos.exception.ProductoNoEncontradoException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
//NUESTRA CLASE MADRE
public class ProductoService {

    //lista donde se almacenas los datos
    private final List<Producto> productos = new ArrayList<>();

    //agregamos productos iniciales de nuestra lista
    public ProductoService() {
        productos.add(new Producto(1L, "Laptop", 850.00, 5));
        productos.add(new Producto(2L, "Mouse", 18.50, 20));
        productos.add(new Producto(3L, "Teclado", 35.00, 10));
    }

    //metodo para consultar los productos
    public List<Producto> listarProducto(){
        //devolvemos la lista de productos
        return productos;
    }

    //metodo para buscar producto por id
    public Producto buscarPorId(Long id) {

        // recorremos la lista y buscamos el id solicitado
        for (Producto producto : productos) {

            // comprobamos si el id coincide
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        // lanzamos una excepcion si no encontramos el producto
        throw new ProductoNoEncontradoException(id);
    }

    //metodo para registar un producto
    public void agregarProducto(Producto producto){

        //validamos que el valor sea mayor a 0
        if (producto.getPrecio() <= 0){
            throw new ProductoInvalidoException("el precio debe ser mayor a cero");
        }

        //validamos que el stock no sea negativo
        if (producto.getStock() < 0 ) {
            throw new ProductoInvalidoException("el stock no puede ser negativo");
        }

        //agregamos el producto si cumple las validaciones
        productos.add(producto);
    }

    //metodo para eliminar un producto
    public void eliminarProducto(Long id){

        //primero buscamos el producto por id
        Producto producto = buscarPorId(id);

        //ahora si eliminamos el producto de la lista
        productos.remove(producto);
    }
}
