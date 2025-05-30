package com.store.commerce.modules.estadoProducto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoProductoRepository extends JpaRepository<EstadoProductoModels, Integer> {
    Optional<EstadoProductoModels> findById(Integer id);
}
