package com.store.commerce.modules.producto;

import com.store.commerce.modules.estadoProducto.EstadoProductoModels;
import com.store.commerce.modules.categoria.CategoriaModels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto") //nombre real de la bd
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private CategoriaModels categoria;

    @OneToOne
    @JoinColumn(name = "idestado_producto")
    private EstadoProductoModels estadoProducto;

    private String nombre;

    private String descripcion;

    private Integer precio;
    private String imagen;
    private Integer estado;

}
