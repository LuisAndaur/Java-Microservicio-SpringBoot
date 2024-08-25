package com.tienda.core.services;

import com.tienda.core.domain.Producto;
import com.tienda.core.interfaces.IProductoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Lazy
@Service("MEMORY")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_MEMORIA"
)
public class ProductoService implements IProductoService {

    public ProductoService(){
        System.out.println("Se está construyendo un objeto de la clase ProductoSrvice");
    }

    public List<Producto> getProductos(){
        return cargarProductos();
    }

    public List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100.0);
        producto1.setStock(10);

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200.0);
        producto2.setStock(20);

        Producto producto3 = new Producto();
        producto3.setId(3);
        producto3.setNombre("Producto 3");
        producto3.setPrecio(300.0);
        producto3.setStock(30);

        // Agregar los productos a la lista
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        return productos;
    }
}