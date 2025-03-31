package com.store.commerce.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "idestado_producto")
    private EstadoProducto estadoProducto;

    private String nombre;

    private String descripcion;

    private Integer precio;

}
