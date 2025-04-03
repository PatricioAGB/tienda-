package com.store.commerce.services;


import com.store.commerce.dto.InventarioDto;

import com.store.commerce.exceptions.BadRequestException;
import com.store.commerce.models.InventarioModels;
import com.store.commerce.models.ProductoModels;
import com.store.commerce.models.UsuarioModels;
import com.store.commerce.repository.InventarioReporitory;
import com.store.commerce.repository.ProductoRepository;
import com.store.commerce.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    private final InventarioReporitory inventarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public InventarioService(InventarioReporitory inventarioRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository) {
        this.inventarioRepository = inventarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
    }

    //Buscar Inventario del Usuario
    public List<InventarioModels> getInventario() {
        return inventarioRepository.findAll();
    }
    //Agregar productos
    public InventarioModels saveInventario(@Valid InventarioDto inventarioDto) {
        // Obtener el usuario desde la base de datos
        UsuarioModels usuario = usuarioRepository.findById(inventarioDto.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        //Validar si el producto existe en la base de datos
        ProductoModels producto = productoRepository.findById(inventarioDto.getProducto().getIdproducto())
                .orElseThrow(() -> new BadRequestException("Producto no encontrado"));
        //Validar si el producto ya esta en el inventario
        boolean existeEnInventario = inventarioRepository.existsByProducto(producto);
        if(existeEnInventario) {
            throw new BadRequestException("Producto ya existe en Inventario");
        }
        // Validar que el usuario sea de tipoUsuario = 2
        if (usuario.getTipoUsuario().getIdTipoUsuario() != 2) {
            throw new BadRequestException("Solo los Vendedores pueden interactuar con el inventario");
        }

        // Si la validación pasa, se guarda el inventario
        InventarioModels inventarioModels = new InventarioModels();
        inventarioModels.setUsuario(inventarioDto.getUsuario());
        inventarioModels.setProducto(inventarioDto.getProducto());
        inventarioModels.setStock(inventarioDto.getStock());
        inventarioModels.setEstado(inventarioDto.getEstado());

        return inventarioRepository.save(inventarioModels);
    }
    public boolean deleteById(Integer id) {
        try {
            Optional<InventarioModels> inventarioOpt = inventarioRepository.findById(id);

            if (inventarioOpt.isPresent()) {
                InventarioModels inventario = inventarioOpt.get();
                inventario.setEstado(0);  // Marcamos el usuario como inactivo
                inventarioRepository.save(inventario);  // Guardamos la actualización
                return true;
            }

            return false;  // Si no se encuentra el usuario
        } catch (Exception e) {
            return false;  // Manejo de errores
        }
    }
}

