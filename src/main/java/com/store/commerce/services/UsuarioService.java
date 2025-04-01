package com.store.commerce.services;


import com.store.commerce.repository.UsuarioRepository;
import com.store.commerce.models.UsuarioModels;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    //Buscar todos los usuarios
    public List<UsuarioModels> getUsuariosActivos() {
        return (List<UsuarioModels>) usuarioRepository.findByActivo(1);
    }
    //Agregar Usuarios
    public UsuarioModels saveUsario(UsuarioModels usuario) {
        return usuarioRepository.save(usuario);
    }
    //Buscar usuario por id
    public Optional<UsuarioModels> getById(Integer id) {
        return usuarioRepository.findById(id);
    }
    // Actualizar usuario por id
    public UsuarioModels updateById(UsuarioModels request, Integer id) {
        UsuarioModels usuario = usuarioRepository.findById(id).get();
        usuario.getTipoUsuario().setNombre(request.getTipoUsuario().getNombre());
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setUsuario(request.getUsuario());
        usuario.setEmail(request.getEmail());
        usuario.setContrasena(request.getContrasena());
        return usuario;
    }
    // eliminar usuario de forma logica
    public boolean deleteById(Integer id) {
        try {
            Optional<UsuarioModels> usuarioOpt = usuarioRepository.findById(id);

            if (usuarioOpt.isPresent()) {
                UsuarioModels usuario = usuarioOpt.get();
                usuario.setActivo(0);  // Marcamos el usuario como inactivo
                usuarioRepository.save(usuario);  // Guardamos la actualización
                return true;
            }

            return false;  // Si no se encuentra el usuario
        } catch (Exception e) {
            return false;  // Manejo de errores
        }
    }

}
