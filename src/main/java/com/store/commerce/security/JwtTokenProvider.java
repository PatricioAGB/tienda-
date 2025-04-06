package com.store.commerce.security;


import com.store.commerce.models.UsuarioModels;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final Key jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    // Metodo para generar el token JWT
    public String generateToken(String user) {
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 1 día
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Metodo para validar el token JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Metodo para obtener el nombre de usuario del token JWT
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}




