package com.hendro.alterra.service;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.model.dao.BrandDao;
import com.hendro.alterra.model.dao.CategoryDao;
import com.hendro.alterra.model.dao.ProductDao;
import com.hendro.alterra.model.dto.ProductDto;
import com.hendro.alterra.repository.BrandRepository;
import com.hendro.alterra.repository.CategoryRepository;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseEntity<Object> getAllProduct() {
        List<ProductDao> daoList = productRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }


    public ResponseEntity<Object> getProductById(Long id) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);
        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build( AppConstant.ResponseCode.NOT_FOUND, "DATA_NOT_FOUND",null, HttpStatus.BAD_REQUEST);
        }
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS", productDaoOptional.get(), HttpStatus.OK);
    }




    public ResponseEntity<Object> saveProduct(ProductDto request) {
        Optional<BrandDao> brandDao = brandRepository.findById(request.getBrandId());
        Optional<CategoryDao> categoryDao = categoryRepository.findById(request.getCategoryId());
        ProductDao productDao = ProductDao.builder()
                .productName(request.getProductName())
                .brand(brandDao.get())
                .category(categoryDao.get())
                .modelYear(request.getModelYear())
                .listPrice(request.getListPrice())
                .build();
        productRepository.save(productDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",productDao, HttpStatus.OK);
    }


    public ResponseEntity<Object> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return ResponseUtil.build( AppConstant.ResponseCode.SUCCESS,"SUCCESS", null,HttpStatus.OK);
    }


    public ResponseEntity<Object> updateProductById(Long id, ProductDto request) {
        Optional<ProductDao> productDaoOptional = productRepository.findById(id);

        if(productDaoOptional.isEmpty()){
            return ResponseUtil.build(AppConstant.ResponseCode.NOT_FOUND,"DATA_NOT_FOUND", null,HttpStatus.BAD_REQUEST);
        }

        productDaoOptional.ifPresent(res -> {
            res.setProductName(request.getProductName());
            res.setModelYear(request.getModelYear());
            res.setListPrice(request.getListPrice());
            productRepository.save(res);
        });

        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS",productDaoOptional.get(),  HttpStatus.OK);
    }

}

