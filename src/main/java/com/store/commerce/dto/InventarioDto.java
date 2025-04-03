package com.store.commerce.dto;

import com.store.commerce.models.ProductoModels;
import com.store.commerce.models.UsuarioModels;
import jakarta.persistence.*;
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
