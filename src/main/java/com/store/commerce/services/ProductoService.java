package com.store.commerce.services;

import com.store.commerce.models.Categoria;
import com.store.commerce.models.EstadoProducto;
import com.store.commerce.models.ProductoModels;
import com.store.commerce.repository.CategoriaRepository;
import com.store.commerce.repository.EstadoProductoRepository;
import com.store.commerce.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private EstadoProductoRepository estadoProductoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProductoModels> getProductos() {
        return productoRepository.findAll();
    }
    public ProductoModels saveProducto(ProductoModels producto) {
        return productoRepository.save(producto);
    }

    // Actualizar producto por id
    public ProductoModels updateById(ProductoModels request, Integer id) {
        ProductoModels producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Busca la categoría y el estadoProducto usando los repositorios
        Categoria categoria = categoriaRepository.findById(request.getCategoria().getIdcategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        EstadoProducto estadoProducto = estadoProductoRepository.findById(request.getEstadoProducto().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado de producto no encontrado"));

        // Actualiza las relaciones
        producto.setCategoria(categoria);
        producto.setEstadoProducto(estadoProducto);

        // Actualiza otros campos y guarda
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());

        // Guarda el producto actualizado
        return productoRepository.save(producto);
    }


}
