package com.store.commerce.web.controller;

import com.store.commerce.dto.ProductoDto;
import com.store.commerce.models.ProductoModels;
import com.store.commerce.models.UsuarioModels;
import com.store.commerce.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    //Buscar Productos
    @GetMapping
    public List<ProductoModels> getProductos() {
        return this.productoService.getProductos();
    }

    //Agregar Producto

    @PostMapping ("/addProducto")// request  en el  body
    public ResponseEntity<ProductoModels> saveProducto(@Valid @RequestBody ProductoDto productoDto) {
        ProductoModels producto = productoService.saveProducto(productoDto);
        return ResponseEntity.ok(producto);
    }

    //Actualizar Producto por id
    @PutMapping(path = "/{id}")
    public ProductoModels updateUserById(@RequestBody ProductoModels request,@PathVariable("id") Integer id) {
        return this.productoService.updateById(request,id);
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<List<ProductoModels>> getProductosByCategoria(@PathVariable("idCategoria") Integer idCategoria) {
        return ResponseEntity.ok(productoService.getProductosByCategoria(idCategoria));
    }
}
