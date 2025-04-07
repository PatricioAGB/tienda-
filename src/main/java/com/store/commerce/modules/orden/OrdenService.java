package com.store.commerce.modules.orden;

import com.store.commerce.modules.producto.ProductoModels;
import com.store.commerce.modules.usuario.UsuarioModels;
import com.store.commerce.modules.producto.ProductoRepository;
import com.store.commerce.modules.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class OrdenService {
    @Autowired
     ProductoRepository productoRepository;
    @Autowired
      OrdenRepository ordenRepository;
    @Autowired
      UsuarioRepository usuarioRepository;

    public OrdenService(OrdenRepository ordenRepository, UsuarioRepository usuarioRepository) {
        this.ordenRepository = ordenRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public OrdenModels insertarOrden(OrdenDto ordenDto) {
        UsuarioModels usuario = usuarioRepository.findById(ordenDto.getIdusuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ProductoModels producto = productoRepository.findById(ordenDto.getIdproducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        OrdenModels orden = new OrdenModels();
        orden.setUsuario(usuario);
        orden.setProducto(producto);
        orden.setCantidad(ordenDto.getCantidad());
        orden.setTotal(ordenDto.getTotal());
        orden.setFecha(LocalDateTime.now());


        return ordenRepository.save(orden);
    }

}
