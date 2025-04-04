package com.store.commerce.models;

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

public class EnvioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idenvio;

    @OneToOne
    @JoinColumn(name = "iddireccion")
    private DireccionModels direccion;

    @OneToOne
    @JoinColumn(name = "idestado_envio")
    private EstadoEnvioModels estadoEnvio;

    @OneToOne
    @JoinColumn(name = "iddatos_contacto")
    private DatosContactoModels datosContacto;

    @OneToOne
    @JoinColumn(name = "idorden")
    private OrdenModels orden;


}
