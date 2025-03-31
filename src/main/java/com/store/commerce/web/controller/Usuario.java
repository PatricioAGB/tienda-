package com.store.commerce.web.controller;



import com.store.commerce.models.UsuarioModels;
import com.store.commerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Usuario {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModels> getUsuarios() {
        return this.usuarioService.getUsuarios();
    }
}
