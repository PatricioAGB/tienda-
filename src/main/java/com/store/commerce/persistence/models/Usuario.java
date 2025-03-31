package com.store.commerce.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")

    @OneToOne
    @JoinColumn(name = "idtipo_usuario")
    private TipoUsuario tipoUsuario;

    private String nombre;

    private String apellido;

    private String usuario;

    private String email;

    private String contrasena;

    private Integer activo;

}
