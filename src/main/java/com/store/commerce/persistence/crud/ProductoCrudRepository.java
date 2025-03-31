package com.store.commerce.persistence.crud;


import com.store.commerce.persistence.models.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByCategoria(int categoria);
}
