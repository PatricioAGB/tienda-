package com.store.commerce.services;

import com.store.commerce.models.UsuarioModels;
import com.store.commerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioModels> getUsuarios() {
        return (List<UsuarioModels>) usuarioRepository.findAll();
    }

    public UsuarioModels saveUsario(UsuarioModels usuario) {
        return this.usuarioRepository.save(usuario);

    }
}
