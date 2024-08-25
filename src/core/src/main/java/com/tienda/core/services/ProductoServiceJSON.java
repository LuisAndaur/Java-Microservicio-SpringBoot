package com.tienda.core.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.core.domain.Producto;
import com.tienda.core.interfaces.IProductoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//@Primary
@Service("JSON")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_JSON"
)
public class ProductoServiceJSON implements IProductoService {


    public List<Producto> getProductos() {
        List<Producto> productos;

        try{
            productos = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/productos.json"),
                            new TypeReference<List<Producto>>() {});

            return productos;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
