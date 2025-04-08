package com.store.commerce.modules.direccion;

import com.store.commerce.modules.tipoDireccion.TipoDireccionModels;
import com.store.commerce.modules.comuna.ComunaModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;

    private TipoDireccionModels tipoDireccion;

    private ComunaModels comuna;

    private String nombre;

    private String departamento;

    private String descripcion;
}
