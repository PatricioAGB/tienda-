package com.store.commerce.modules.producto;


import com.store.commerce.modules.categoria.CategoriaModels;
import com.store.commerce.modules.estadoProducto.EstadoProductoModels;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDto {

    private Integer idproducto;
    private CategoriaModels categoria;
    private EstadoProductoModels estadoProducto;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private String descripcion;

    private Integer precio;
    private String imagen;
    private Integer estado;
}
