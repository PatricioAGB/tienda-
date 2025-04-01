package com.store.commerce.repository;


import com.store.commerce.models.UsuarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModels, Integer> {
    List<UsuarioModels> findByActivo(Integer activo);
}
