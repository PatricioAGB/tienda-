package com.store.commerce.web.controller;



import com.store.commerce.models.UsuarioModels;
import com.store.commerce.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Buscar usuario
    @GetMapping
    public List<UsuarioModels> getUsuariosActivos() {
        return this.usuarioService.getUsuariosActivos();
    }
    //Agregar Usuario
    @RequestMapping("/addUser")
    @PostMapping // request  en el  body
    public ResponseEntity<UsuarioModels> saveUsuario(@RequestBody UsuarioModels usuario) {
       usuarioService.saveUsario(usuario);
       return ResponseEntity.ok(usuario);
    }
    //Busca Usuario por id
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> getUserById(@PathVariable Integer id) {
        return this.usuarioService.getById(id);
    }
    //Actualizar usuario por id
    @PutMapping(path = "/{id}")
    public UsuarioModels updateUserById(@RequestBody UsuarioModels request,@PathVariable("id") Integer id) {
        return this.usuarioService.updateById(request,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        boolean ok = this.usuarioService.deleteById(id);
        if (ok) {
            return "Usuario con id " + id + " desactivado (borrado lógico)";
        } else {
            return "Usuario no encontrado o no se pudo desactivar";
        }
    }


}