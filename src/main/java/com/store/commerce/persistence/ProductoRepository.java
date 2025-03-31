package com.store.commerce.persistence;

import com.store.commerce.persistence.crud.ProductoCrudRepository;
import com.store.commerce.persistence.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){ return (List<Producto>) productoCrudRepository.findAll();}

    public List<Producto> getByCategoria(int categoria){
        return  productoCrudRepository.findByCategoria(categoria);

    }

    public Optional<Producto> getById(int idproducto){
        return productoCrudRepository.findById(idproducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idproducto){
        productoCrudRepository.deleteById(idproducto);
    }
}
