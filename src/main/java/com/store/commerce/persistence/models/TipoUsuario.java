package com.store.commerce.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// creacion tabla "tipo_usuario"
@Entity
@Table (name = "tipo_usuario") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoUsuario {
    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "idtipo_usuario")
    private Integer idTipoUsuario;

    private String nombre;


}
