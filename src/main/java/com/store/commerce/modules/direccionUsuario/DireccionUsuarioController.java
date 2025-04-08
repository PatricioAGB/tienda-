package com.store.commerce.modules.direccionUsuario;

import com.store.commerce.modules.estadoProducto.EstadoProductoRepository;
import com.store.commerce.modules.usuario.UsuarioModels;
import com.store.commerce.modules.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direccionUsuario")
public class DireccionUsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    DireccionUsuarioRepository direccionUsuarioRepository;
    @Autowired
    private DireccionUsuarioService direccionUsuarioService;

    @GetMapping("{id}")
    public ResponseEntity<List<DireccionUsuarioModels>> obtenerDireccionesPorUsuario(@PathVariable("id") Integer idUsuario) {

        UsuarioModels usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<DireccionUsuarioModels> direcciones = direccionUsuarioRepository.findByUsuario(usuario);
        return ResponseEntity.ok(direcciones);
    }

    @PostMapping("/addDireccionUsuario")
    public ResponseEntity<DireccionUsuarioModels> crearDireccionUsuario(@RequestBody DireccionUsuarioDto dto) {
        DireccionUsuarioModels nueva = direccionUsuarioService.guardarDireccionUsuario(dto);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }
}
