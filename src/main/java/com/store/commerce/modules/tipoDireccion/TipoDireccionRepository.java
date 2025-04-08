package com.store.commerce.modules.tipoDireccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDireccionRepository extends JpaRepository<TipoDireccionModels,Integer> {
}
