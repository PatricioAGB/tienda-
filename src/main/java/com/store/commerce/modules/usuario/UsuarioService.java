package com.store.commerce.modules.usuario;


import com.store.commerce.modules.fielderror.FieldErrorDTO;
import com.store.commerce.exceptions.BadRequestException;
import com.store.commerce.security.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    JwtTokenProvider jwtTokenProvider;

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
            List<FieldErrorDTO> errors =List.of(new FieldErrorDTO("usuario","El nombre de usuario ya está en uso"));
            throw new BadRequestException(errors);
        }

        if (usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
            List<FieldErrorDTO> errors =List.of(new FieldErrorDTO("email","El correo electrónico ya está registrado"));
            throw new BadRequestException(errors);
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
        return usuarioRepository.findByIdUsuarioAndActivo(idUsuario, 1);
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

            List<FieldErrorDTO> errors =List.of(new FieldErrorDTO("deleteUsuario","Error al eliminar el usuario"));
            throw new BadRequestException(errors);
        } catch (Exception e) {
            List<FieldErrorDTO> errors =List.of(new FieldErrorDTO("delteUsuario","error al eliminar el usuario"));
            throw new BadRequestException(errors);
        }
    }

    //Iniciar Sesion
    public String login(String userOrEmail, String contrasena) {
        // Buscar el usuario por usuario o correo
        Optional<UsuarioModels> usuarioOpt = usuarioRepository.findByUsuarioOrEmailAndActivo(userOrEmail, userOrEmail,1);

        // Verificar si el usuario existe
        if (usuarioOpt.isPresent()) {
            UsuarioModels usuario = usuarioOpt.get();

            // Verificar si el usuario está activo (activo == 1)
            if (usuario.getActivo() != 1) {
                return "Usuario no activo"; // Retornar un mensaje indicando que el usuario no está activo
            }

            // Verificar la contraseña
            if (passwordEncoder.matches(contrasena, usuario.getContrasena())) {
                // Si las credenciales son correctas, generar el token JWT
                String jwt = jwtTokenProvider.generateToken(usuario.getUsuario());
                return "Bearer " + jwt;  // Retorna el token con el prefijo 'Bearer '
            } else {
                return "Contraseña incorrecta";
            }
        } else {
            return "Usuario no encontrado";
        }

    }
    public UsuarioModels findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre: " + usuario));
    }
}
