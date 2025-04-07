package com.store.commerce.modules.producto;

import com.store.commerce.modules.categoria.CategoriaModels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModels, Integer> {

    List<ProductoModels> findByCategoria(CategoriaModels categoria);
}
