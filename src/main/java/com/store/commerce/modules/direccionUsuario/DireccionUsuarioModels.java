package com.store.commerce.modules.direccionUsuario;

import com.store.commerce.modules.direccion.DireccionModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccion_usuario") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionUsuarioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion_usuario")
    private Integer idDireccionUsuario;

    @ManyToOne
    @JoinColumn(name = "iddireccion")
    private DireccionModels direccion;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioModels usuario;

    private String nombre;
    private Integer estado;


}
