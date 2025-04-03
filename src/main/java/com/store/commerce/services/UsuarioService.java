package com.store.commerce.services;


import com.store.commerce.dto.UsuarioDto;
import com.store.commerce.exceptions.BadRequestException;
import com.store.commerce.repository.UsuarioRepository;
import com.store.commerce.models.UsuarioModels;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;
    //Buscar todos los usuarios
    public List<UsuarioModels> getUsuariosActivos() {
        return (List<UsuarioModels>) usuarioRepository.findByActivo(1);
    }
    //Agregar Usuarios
    public UsuarioModels saveUsario(@Valid UsuarioDto usuarioDto) {
        if (usuarioRepository.existsByUsuario(usuarioDto.getUsuario())) {
            throw new BadRequestException("El nombre de usuario ya está en uso");
        }

        if (usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
            throw new BadRequestException("El correo electrónico ya está registrado");
        }

        String contrasenaEncriptada = passwordEncoder.encode(usuarioDto.getContrasena());

        UsuarioModels usuario = new UsuarioModels();
        usuario.setTipoUsuario(usuarioDto.getTipoUsuario());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setContrasena(contrasenaEncriptada);
        usuario.setActivo(usuarioDto.getActivo());

        return usuarioRepository.save(usuario);
    }
    //Buscar usuario por id
    public Optional<UsuarioModels> getById(Integer idUsuario) {
        return usuarioRepository.findByIdUsuarioAndActivo(idUsuario,1);
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

    //Iniciar Sesion
    public String login(String userOEmail, String contrasena) {
        //Obtener todos los usuarios activos
        List<UsuarioModels> usuariosActivos = usuarioRepository.findByActivo(1);

        //Buscar si existe el usuario con el correo o usuario ingresado
        Optional<UsuarioModels> usuarioOpt = usuariosActivos.stream()
                .filter(u -> u.getUsuario().equalsIgnoreCase(userOEmail) || u.getEmail().equalsIgnoreCase(userOEmail))
                .findFirst();

        if (usuarioOpt.isPresent()) {
            UsuarioModels usuario = usuarioOpt.get();

            // Verifica la contraseña
            if(passwordEncoder.matches(contrasena, usuario.getContrasena())) {
                return "Inicio de sesión exitoso para el usuario: " + usuario.getUsuario();
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Usuario no encontrado o inactivo";
        }
    }
}
