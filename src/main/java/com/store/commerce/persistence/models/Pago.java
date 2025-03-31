package com.store.commerce.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pago") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;

    @OneToOne
    @JoinColumn(name = "idorden")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "idmetodo_pago")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "idestado_pago")
    private EstadoPago estadoPago;

}
