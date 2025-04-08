package com.store.commerce.modules.usuario;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    @PostMapping("/register")// request  en el  body
    public ResponseEntity<UsuarioModels> saveUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
        // Intentar registrar el usuario
        UsuarioModels nuevoUsuario = usuarioService.saveUsario(usuarioDto);
        return ResponseEntity.ok(nuevoUsuario);
    }

    //Busca Usuario por id
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> getUserById(@PathVariable Integer id) {
        return this.usuarioService.getById(id);
    }

    //Actualizar usuario por id
    @PutMapping(path = "/{id}")
    public UsuarioModels updateUserById(@RequestBody UsuarioModels request, @PathVariable("id") Integer id) {
        return this.usuarioService.updateById(request, id);
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

    //Inicio de sesion
    @PostMapping("/a")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String userOEmail = request.get("userOrEmail");
        String contrasena = request.get("contrasena");

        String response = usuarioService.login(userOEmail, contrasena);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find/{usuario}")
    public ResponseEntity<UsuarioModels> obtenerPorNombreUsuario(@PathVariable String usuario) {
        UsuarioModels usuarioEncontrado = usuarioService.findByUsuario(usuario);
        return ResponseEntity.ok(usuarioEncontrado);
    }


}