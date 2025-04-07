package com.store.commerce.models;

import com.store.commerce.modules.comuna.ComunaModels;
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
public class DireccionModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    @OneToOne
    @JoinColumn(name = "idtipo_direccion")
    private TipoDireccionModels tipoDireccion;

    @ManyToOne
    @JoinColumn(name = "idcomuna")
    private ComunaModels comuna;

    private String nombre;

    private String departamento;

    private String descripcion;
}
