package com.store.commerce.modules.comuna;

import com.store.commerce.modules.region.RegionModels;
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
public class ComunaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomuna;

    @ManyToOne
    @JoinColumn(name = "idregion")
    private RegionModels region;

    private String nombre;
}
