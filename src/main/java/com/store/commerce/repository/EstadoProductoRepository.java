package com.store.commerce.repository;

import com.store.commerce.models.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoProductoRepository extends JpaRepository<EstadoProducto, Integer> {
    Optional<EstadoProducto> findById(Integer id);
}
