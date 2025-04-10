package com.store.commerce.modules.tipoDireccion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_direccion") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDireccionModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo_direccion")
    private Integer idTipoDireccion;

    private String nombre;

}
