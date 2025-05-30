package com.store.commerce.modules.inventario;

import com.store.commerce.modules.producto.ProductoModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventario") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idinventario;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioModels usuario;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private ProductoModels producto;

    private Integer stock;

    private Integer estado;

}
