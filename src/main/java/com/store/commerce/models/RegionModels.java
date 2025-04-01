package com.store.commerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegionModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idregion;

    private String nombre;
}

