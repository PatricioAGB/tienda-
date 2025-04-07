package com.store.commerce.modules.orden;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearOrden(@RequestBody OrdenDto ordenDto) {
        OrdenModels ordenGuardada = ordenService.insertarOrden(ordenDto);
        return ResponseEntity.ok(ordenGuardada);
    }
}
