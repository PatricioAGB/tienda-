package com.store.commerce.modules.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModels, Integer> {
    Optional<CategoriaModels> findById(Integer id);
}
