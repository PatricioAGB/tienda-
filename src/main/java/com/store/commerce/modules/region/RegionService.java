package com.store.commerce.modules.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;


    public List<RegionModels> getRegions() {
        return regionRepository.findAll();
    }
}
