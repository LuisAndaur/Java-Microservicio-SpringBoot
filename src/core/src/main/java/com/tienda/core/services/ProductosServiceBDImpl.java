package com.tienda.core.services;

import com.tienda.core.domain.Producto;
import com.tienda.core.interfaces.IProductoService;
import com.tienda.core.persistance.entities.ProductoEntity;
import com.tienda.core.persistance.repositories.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("BD")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_BD"
)
public class ProductosServiceBDImpl implements IProductoService {

    @Autowired
    private IProductosRepository _productosRepository;

    public List<Producto> getProductos(){
        List<Producto> productos = _productosRepository.findAll()
                .stream().map(productEntity -> {
                    Producto producto = new Producto();
                    producto.setId(productEntity.getId());
                    producto.setNombre(productEntity.getNombre());
                    producto.setPrecio(productEntity.getPrecio());
                    producto.setStock(productEntity.getStock());

                    return producto;
                }).collect(Collectors.toList());
        /*
        List<ProductoEntity> productosEntities = _productosRepository.findAll();
        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity productEntity : productosEntities){
            Producto producto = new Producto();
            producto.setId(productEntity.getId());
            producto.setNombre(productEntity.getNombre());
            producto.setPrecio(productEntity.getPrecio());
            producto.setStock(productEntity.getStock());

            productos.add(producto);
        }
         */
        return productos;
    }
}
