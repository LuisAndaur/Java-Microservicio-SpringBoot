package com.tienda.core.persistance.repositories;

import com.tienda.core.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<ProductoEntity, Integer> {
}
