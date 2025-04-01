package com.store.commerce.repository;

import com.store.commerce.models.ProductoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository <ProductoModels, Integer> {
}
