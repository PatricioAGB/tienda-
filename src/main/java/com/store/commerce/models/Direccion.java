package com.store.commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direccion") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    @OneToOne
    @JoinColumn(name = "idtipo_direccion")
    private TipoDireccion tipoDireccion;

    @ManyToOne
    @JoinColumn(name = "idcomuna")
    private Comuna comuna;

    private String nombre;

    private String departamento;

    private String descripcion;
}
