package com.store.commerce.modules.usuario;

import com.store.commerce.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Endpoint para autenticación y devolver JWT
    @PostMapping("/login")
    // Iniciar Sesion
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        // Extraer datos del JSON
        String userOrEmail = request.get("userOrEmail");
        String contrasena = request.get("contrasena");

        // Buscar el usuario activo por usuario o correo
        Optional<UsuarioModels> usuarioOpt = usuarioRepository.findByUsuarioOrEmailAndActivo(userOrEmail, userOrEmail, 1);

        // Verificar si el usuario existe
        if (usuarioOpt.isPresent()) {
            UsuarioModels usuario = usuarioOpt.get();

            // Verificar la contraseña
            if (passwordEncoder.matches(contrasena, usuario.getContrasena())) {
                // Si las credenciales son correctas, generar el token JWT
                String jwt = tokenProvider.generateToken(usuario.getUsuario());
                return ResponseEntity.ok("Bearer " + jwt);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado o no activo");
        }
    }
}
