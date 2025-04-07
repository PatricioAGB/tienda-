package com.store.commerce.modules.inventario;

import com.store.commerce.modules.producto.ProductoModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioDto {

    private Integer idinventario;

    private UsuarioModels usuario;

    private ProductoModels producto;

    @NotBlank
    private Integer stock;

    private Integer estado;

}
