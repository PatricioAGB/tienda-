package com.store.commerce.modules.orden;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdenDto {

    private Integer idorden;

    private Integer idusuario;

    private Integer idproducto;

    private Date fecha;

    private Integer cantidad;

    private Integer total;

}
