package com.store.commerce.modules.comuna;

import com.store.commerce.modules.region.RegionModels;
import com.store.commerce.modules.region.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComunaService {
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    ComunaRepository comunaRepository;

    public List<ComunaModels> region(Integer idRegion) {
        RegionModels region = regionRepository.findById(idRegion)
                .orElseThrow(() -> new RuntimeException("region no encontrada"));
        return comunaRepository.findByRegion(region);
    }
}
