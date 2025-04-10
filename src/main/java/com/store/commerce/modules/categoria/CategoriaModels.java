package com.store.commerce.modules.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategoria;

    private String nombre;
}
