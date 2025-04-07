package com.store.commerce.modules.inventario;

import com.store.commerce.modules.compra.CompraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    CompraDto compraDto;

    @Autowired
    InventarioService inventarioService;

    //Buscar Inventario
    @GetMapping
    public List<InventarioModels> getInventario() {
        return this.inventarioService.getInventario();
    }

    @PostMapping("/addInventario")// request  en el  body
    public ResponseEntity<InventarioModels> saveInventario(@RequestBody InventarioDto inventarioDto) {
        InventarioModels inventario = inventarioService.saveInventario(inventarioDto);
        return ResponseEntity.ok(inventario);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        boolean ok = this.inventarioService.deleteById(id);
        if (ok) {
            return "Inventario eliminado";
        } else {
            return "inventario no encontrado o no se pudo desactivar";
        }
    }

    @PostMapping("/comprar")
    public ResponseEntity<?> comprarProducto(@RequestBody CompraDto compraDto) {
        // Asegurémonos de que NO sea null
        System.out.println("CompraDto recibido: " + compraDto);

        InventarioModels actualizado = inventarioService.actualizarStockPorCompra(compraDto);
        return ResponseEntity.ok(actualizado);
    }




}
