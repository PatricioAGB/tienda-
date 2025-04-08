package com.store.commerce.modules.direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DireccionController {


    @Autowired
    private DireccionService direccionService;

    @PostMapping("/AddDireccion")
    public ResponseEntity<DireccionModels> crearDireccion(@RequestBody DireccionDto direccionDto) {
        DireccionModels nuevaDireccion = direccionService.guardarDireccion(direccionDto);
        return new ResponseEntity<>(nuevaDireccion, HttpStatus.CREATED);
    }
}
