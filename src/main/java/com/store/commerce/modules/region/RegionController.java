package com.store.commerce.modules.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
     RegionService regionService;
    @GetMapping
    public List<RegionModels> getRegions() {
        return this.regionService.getRegions();
    }

}
