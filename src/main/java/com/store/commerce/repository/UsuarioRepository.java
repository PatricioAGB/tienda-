package com.store.commerce.repository;


import com.store.commerce.models.UsuarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModels, Integer> {
    List<UsuarioModels> findByActivo(Integer activo); //Buscar por Usuarios Activos
    Optional<UsuarioModels> findByUsuarioOrEmail(String usuario, String email); // Buscar por usuario y email

    boolean existsByUsuario(String usuario); //Busca los Usuarios
    boolean existsByEmail(String email); // Busca los Emails
    //buscar por id y usuario activo
    Optional<UsuarioModels> findByIdUsuarioAndActivo(Integer idUsuario, Integer activo);


}

//