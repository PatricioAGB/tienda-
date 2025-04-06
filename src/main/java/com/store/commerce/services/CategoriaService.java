package com.store.commerce.services;

import com.store.commerce.models.CategoriaModels;
import com.store.commerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModels> getCategorias() {

        return categoriaRepository.findAll();
    }
}
