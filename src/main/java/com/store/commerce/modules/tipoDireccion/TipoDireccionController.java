package com.store.commerce.modules.tipoDireccion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoDireccion")
public class TipoDireccionController {
    @Autowired
    TipoDireccionService tipoDireccionService;
    @GetMapping
    public List<TipoDireccionModels> getTipoDireccion() {
        return this.tipoDireccionService.getTipoDireccion();
    }
}
