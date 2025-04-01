package com.store.commerce.repository;

import com.store.commerce.models.CategoriaModels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModels, Integer> {
  Optional<CategoriaModels> findById(Integer id);
}
