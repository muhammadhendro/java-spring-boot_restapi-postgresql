package com.hendro.alterra.controller;

import com.hendro.alterra.model.dto.StockDto;
import com.hendro.alterra.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/stock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return stockService.getAllStock();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveStock(@RequestBody StockDto request) {
        return stockService.saveStock(request);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return stockService.deleteStock(id);
    }

}