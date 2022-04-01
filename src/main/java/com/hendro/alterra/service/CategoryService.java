package com.hendro.alterra.service;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.model.dao.CategoryDao;
import com.hendro.alterra.model.dto.CategoryDto;
import com.hendro.alterra.repository.CategoryRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<Object> getAllCategory() {
        List<CategoryDao> daoList = categoryRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    public ResponseEntity<Object> saveCategory(CategoryDto request) {
        CategoryDao categoryDao = CategoryDao.builder()
                .categoryName(request.getCategoryName())
                .build();
        categoryRepository.save(categoryDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",categoryDao, HttpStatus.OK);
    }

}
