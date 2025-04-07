package com.store.commerce.modules.region;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionModels, Integer> {
    Optional<RegionModels> findById(Integer idRegion);
}
