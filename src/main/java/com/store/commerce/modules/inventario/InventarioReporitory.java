package com.store.commerce.modules.inventario;

import com.store.commerce.modules.producto.ProductoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventarioReporitory extends JpaRepository<InventarioModels, Integer> {
    boolean existsByProducto(ProductoModels producto);
    Optional<InventarioModels> findByProducto(ProductoModels producto);

}
