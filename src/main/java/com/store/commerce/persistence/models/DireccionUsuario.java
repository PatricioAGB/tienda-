package com.store.commerce.persistence.models;

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
public class DireccionUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion_usuario")
    private Integer idDireccionUsuario;

    @ManyToOne
    @JoinColumn(name = "iddireccion")
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private String nombre;


}
