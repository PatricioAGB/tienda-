package com.store.commerce.dto;


import com.store.commerce.models.CategoriaModels;
import com.store.commerce.models.EstadoProductoModels;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Debe ingresar un precio")
    private Integer precio;
}
