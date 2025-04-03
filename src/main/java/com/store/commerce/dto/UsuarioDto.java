package com.store.commerce.dto;

import com.store.commerce.models.TipoUsuarioModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {


    private Integer idUsuario;
    private TipoUsuarioModels tipoUsuario;
    //Validacion de Ingreso de nombre
    @NotBlank(message = "El nombre no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre no debe contener números ni caracteres especiales")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido no debe contener números ni caracteres especiales")
    private String apellido;

    private String usuario;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Debe ser un correo electronico valido")
    private String email;

    @NotBlank(message = "La contrasena no puede estar vacío")
    @Size(min = 5, message = "La contrasena debe tener al menos 5 caracteres")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\":{}|<>].*", message = "La contraseña debe contener al menos un carácter especial")
    private String contrasena;
    private Integer activo;
}
