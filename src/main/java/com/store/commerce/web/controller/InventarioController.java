package com.store.commerce.web.controller;

import com.store.commerce.dto.InventarioDto;
import com.store.commerce.dto.ProductoDto;
import com.store.commerce.models.InventarioModels;
import com.store.commerce.models.ProductoModels;
import com.store.commerce.services.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;
    //Buscar Inventario
    @GetMapping
    public List<InventarioModels> getInventario() {
        return this.inventarioService.getInventario();
    }

    @PostMapping("/addInventario")// request  en el  body
    public ResponseEntity<InventarioModels> saveInventario( @RequestBody InventarioDto inventarioDto) {
        InventarioModels inventario = inventarioService.saveInventario(inventarioDto);
        return ResponseEntity.ok(inventario);
    }

}
