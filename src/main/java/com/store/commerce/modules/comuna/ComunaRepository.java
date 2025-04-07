package com.store.commerce.modules.comuna;


import com.store.commerce.modules.region.RegionModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComunaRepository extends JpaRepository<ComunaModels, Integer> {
    List<ComunaModels> findByRegion(RegionModels region);
}
