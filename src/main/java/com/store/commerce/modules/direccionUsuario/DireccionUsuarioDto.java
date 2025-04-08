package com.store.commerce.modules.direccionUsuario;

import com.store.commerce.modules.direccion.DireccionModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionUsuarioDto {

    private Integer idDireccionUsuario;
    private Integer idDireccion;
    private Integer idUsuario;

    private String nombre;
    private Integer estado;


}
