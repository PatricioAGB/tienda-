package com.store.commerce.services;


import com.store.commerce.dto.InventarioDto;

import com.store.commerce.exceptions.BadRequestException;
import com.store.commerce.models.InventarioModels;
import com.store.commerce.models.UsuarioModels;
import com.store.commerce.repository.InventarioReporitory;
import com.store.commerce.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioReporitory inventarioRepository;
    private final UsuarioRepository usuarioRepository;

    public InventarioService(InventarioReporitory inventarioRepository, UsuarioRepository usuarioRepository) {
        this.inventarioRepository = inventarioRepository;
        this.usuarioRepository = usuarioRepository;
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

        // Validar que el usuario sea de tipoUsuario = 2
        if (usuario.getTipoUsuario().getIdTipoUsuario() != 2) {
            throw new BadRequestException("Solo los Vendedores pueden interactuar con el inventario");
        }

        // Si la validación pasa, se guarda el inventario
        InventarioModels inventarioModels = new InventarioModels();
        inventarioModels.setUsuario(inventarioDto.getUsuario());
        inventarioModels.setProducto(inventarioDto.getProducto());
        inventarioModels.setStock(inventarioDto.getStock());

        return inventarioRepository.save(inventarioModels);
    }





}

