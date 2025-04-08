package com.store.commerce.modules.tipoDireccion;

import com.store.commerce.modules.region.RegionModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDireccionService {
    @Autowired
    TipoDireccionRepository tipoDireccionRepository;
    public List<TipoDireccionModels> getTipoDireccion() {

        return tipoDireccionRepository.findAll();
    }
}

