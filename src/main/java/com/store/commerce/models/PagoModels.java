package com.store.commerce.models;

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
public class PagoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;

    @OneToOne
    @JoinColumn(name = "idorden")
    private OrdenModels orden;

    @ManyToOne
    @JoinColumn(name = "idmetodo_pago")
    private MetodoPagoModels metodoPago;

    @ManyToOne
    @JoinColumn(name = "idestado_pago")
    private EstadoPagoModels estadoPago;

}
