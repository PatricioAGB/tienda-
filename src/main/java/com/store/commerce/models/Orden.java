package com.store.commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "orden") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorden;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private Date fecha;

    private Integer total;


}
