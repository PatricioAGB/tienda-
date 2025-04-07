package com.store.commerce.modules.comuna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comuna")
public class ComunaController {
    @Autowired
    ComunaService comunaService;

    @GetMapping("/{idRegion}")
    public ResponseEntity<List<ComunaModels>> getComunaByRegion(@PathVariable("idRegion") Integer idRegion) {
        return ResponseEntity.ok(comunaService.region(idRegion));
    }
}
