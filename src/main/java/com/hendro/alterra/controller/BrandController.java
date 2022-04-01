package com.hendro.alterra.controller;

import com.hendro.alterra.model.dto.BrandDto;
import com.hendro.alterra.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/brand", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return brandService.getAllBrand();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveBrand(@RequestBody BrandDto request) {
        return brandService.saveBrand(request);
    }
}