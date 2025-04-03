package com.store.commerce.repository;

import com.store.commerce.models.InventarioModels;
import com.store.commerce.models.ProductoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioReporitory extends JpaRepository <InventarioModels, Integer> {
    boolean existsByProducto(ProductoModels producto);
}
