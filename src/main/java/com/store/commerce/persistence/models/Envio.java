package com.store.commerce.persistence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "envio") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idenvio;

    @OneToOne
    @JoinColumn(name = "iddireccion")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name = "idestado_envio")
    private EstadoEnvio estadoEnvio;

    @OneToOne
    @JoinColumn(name = "iddatos_contacto")
    private DatosContacto datosContacto;

    @OneToOne
    @JoinColumn(name = "idorden")
    private Orden orden;




}
