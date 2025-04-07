package com.store.commerce.modules.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    //Buscar usuario
    @GetMapping
    public List<CategoriaModels> getCategorias() {
        return this.categoriaService.getCategorias();
    }
}

