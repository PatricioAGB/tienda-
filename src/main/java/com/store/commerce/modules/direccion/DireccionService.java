package com.store.commerce.modules.direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public DireccionModels guardarDireccion(DireccionDto direccionDto) {
        DireccionModels direccion = new DireccionModels();
        direccion.setComuna(direccionDto.getComuna());
        direccion.setTipoDireccion(direccionDto.getTipoDireccion());
        direccion.setNombre(direccionDto.getNombre());
        direccion.setDepartamento(direccionDto.getDepartamento());
        direccion.setDescripcion(direccionDto.getDescripcion());

        return direccionRepository.save(direccion);
    }
}



