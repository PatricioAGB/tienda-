package com.store.commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orden_detalle") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorden_detalle")
    private Integer idOrdenDetalle;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductoModels producto;

    @ManyToOne
    @JoinColumn(name = "idorden")
    private OrdenModels orden;

    private Integer cantidad;

    private Integer subtotal;



}

