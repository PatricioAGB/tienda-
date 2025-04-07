package com.store.commerce.modules.orden;

import com.store.commerce.modules.producto.ProductoModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "orden") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class OrdenModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorden;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioModels usuario;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductoModels producto;

    private LocalDateTime fecha;

    private Integer cantidad;

    private Integer total;


}
