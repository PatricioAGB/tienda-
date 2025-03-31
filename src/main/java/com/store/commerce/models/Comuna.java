package com.store.commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comuna") //nombre real de la bd

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomuna;

    @ManyToOne
    @JoinColumn(name = "idregion")
    private Region region;

    private String nombre;
}
