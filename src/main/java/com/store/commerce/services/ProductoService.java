package com.store.commerce.services;

import com.store.commerce.dto.ProductoDto;
import com.store.commerce.models.CategoriaModels;
import com.store.commerce.models.EstadoProductoModels;
import com.store.commerce.models.ProductoModels;
import com.store.commerce.repository.CategoriaRepository;
import com.store.commerce.repository.EstadoProductoRepository;
import com.store.commerce.repository.ProductoRepository;
import jakarta.validation.Valid;
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

    //encuentra todos los productos
    public List<ProductoModels> getProductos() {
        return productoRepository.findAll();
    }
    //Guardar un nuevo producto
    public ProductoModels saveProducto(@Valid ProductoDto productoDto) {
        ProductoModels productoModels = new ProductoModels();
        productoModels.setIdproducto(productoDto.getIdproducto());
        productoModels.setCategoria(productoDto.getCategoria());
        productoModels.setEstadoProducto(productoDto.getEstadoProducto());
        productoModels.setNombre(productoDto.getNombre());
        productoModels.setNombre(productoDto.getNombre());
        productoModels.setDescripcion(productoDto.getDescripcion());
        productoModels.setPrecio(productoDto.getPrecio());
        return productoRepository.save(productoModels);
    }

    // Actualizar producto por id
    public ProductoModels updateById(ProductoModels request, Integer id) {
        ProductoModels producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Busca la categoría y el estadoProducto usando los repositorios
        CategoriaModels categoria = categoriaRepository.findById(request.getCategoria().getIdcategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        EstadoProductoModels estadoProducto = estadoProductoRepository.findById(request.getEstadoProducto().getIdEstado())
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
        public List<ProductoModels> getProductosByCategoria(Integer idCategoria) {
        CategoriaModels categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return productoRepository.findByCategoria(categoria);
        }


}
