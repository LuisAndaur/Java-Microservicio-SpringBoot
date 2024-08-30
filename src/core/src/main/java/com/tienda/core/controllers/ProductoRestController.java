package com.tienda.core.controllers;

import com.tienda.core.configurations.ConfigurationParameters;
import com.tienda.core.domain.Producto;
import com.tienda.core.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    @Lazy
    //@Qualifier("JSON")
    private IProductoService _productoService;
    @Autowired
    private ConfigurationParameters _configurationParameters;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        System.out.println("params: " + _configurationParameters.toString());
        List<Producto> productos = _productoService.getProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/fake-productos")
    public ResponseEntity<?> fakeProductosAPI(){
        List<Producto> productos = cargarProductos();
        return ResponseEntity.ok(productos);
    }

    public List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Televisor");
        producto1.setPrecio(100.0);
        producto1.setStock(10);

        Producto producto2 = new Producto();
        producto2.setId(2);
        producto2.setNombre("Termo");
        producto2.setPrecio(200.0);
        producto2.setStock(20);

        Producto producto3 = new Producto();
        producto3.setId(3);
        producto3.setNombre("Parlante");
        producto3.setPrecio(300.0);
        producto3.setStock(30);

        // Agregar los productos a la lista
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        return productos;
    }
}
