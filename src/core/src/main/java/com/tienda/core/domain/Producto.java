package com.tienda.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;
}
