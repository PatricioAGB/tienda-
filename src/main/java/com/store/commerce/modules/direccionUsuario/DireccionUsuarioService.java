package com.store.commerce.modules.direccionUsuario;


import com.store.commerce.modules.direccion.DireccionModels;
import com.store.commerce.modules.direccion.DireccionRepository;
import com.store.commerce.modules.usuario.UsuarioModels;
import com.store.commerce.modules.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DireccionUsuarioService {
    @Autowired
    private DireccionUsuarioRepository direccionUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    public List<DireccionUsuarioModels> usuario(Integer IdUsuario) {
        UsuarioModels usuario = usuarioRepository.findByIdUsuarioAndActivo(IdUsuario,1)
                .orElseThrow(() -> new RuntimeException("region no encontrada"));
        return direccionUsuarioRepository.findByUsuario(usuario);
    }

    public DireccionUsuarioModels guardarDireccionUsuario(DireccionUsuarioDto dto) {
        DireccionModels direccion = direccionRepository.findById(dto.getIdDireccion())
                .orElseThrow(() -> new RuntimeException("Dirección no encontrada"));

        UsuarioModels usuario = usuarioRepository.findByIdUsuarioAndActivo(dto.getIdUsuario(),1)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        DireccionUsuarioModels direccionUsuario = new DireccionUsuarioModels();
        direccionUsuario.setDireccion(direccion);
        direccionUsuario.setUsuario(usuario);
        direccionUsuario.setNombre(dto.getNombre());
        direccionUsuario.setEstado(1);

        return direccionUsuarioRepository.save(direccionUsuario);
    }

}
