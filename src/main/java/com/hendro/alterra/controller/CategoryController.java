package com.hendro.alterra.controller;

import com.hendro.alterra.model.dto.CategoryDto;
import com.hendro.alterra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return categoryService.getAllCategory();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveCategory(@RequestBody CategoryDto request) {
        return categoryService.saveCategory(request);
    }

}

