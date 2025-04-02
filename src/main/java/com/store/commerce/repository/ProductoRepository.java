package com.store.commerce.repository;

import com.store.commerce.models.CategoriaModels;
import com.store.commerce.models.ProductoModels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository  extends JpaRepository <ProductoModels, Integer> {
    List<ProductoModels> findByCategoria(CategoriaModels categoria);
}
