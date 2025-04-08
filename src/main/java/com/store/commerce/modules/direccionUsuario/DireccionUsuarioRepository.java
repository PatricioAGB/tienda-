package com.store.commerce.modules.direccionUsuario;


import com.store.commerce.modules.usuario.UsuarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionUsuarioRepository extends JpaRepository<DireccionUsuarioModels, Integer> {
    List<DireccionUsuarioModels> findByUsuario(UsuarioModels IdUsuario);
}
