package com.tienda.core.controllers;

import com.tienda.core.domain.Producto;
import com.tienda.core.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    @Lazy
    //@Qualifier("JSON")
    private IProductoService _productoService;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        List<Producto> productos = _productoService.getProductos();
        return ResponseEntity.ok(productos);
    }
}
