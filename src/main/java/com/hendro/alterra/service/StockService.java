package com.hendro.alterra.service;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.model.dao.BrandDao;
import com.hendro.alterra.model.dao.ProductDao;
import com.hendro.alterra.model.dao.StockDao;
import com.hendro.alterra.model.dto.StockDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.repository.StockRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getAllStock() {
        List<StockDao> daoList = stockRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    public ResponseEntity<Object> saveStock(StockDto request) {
        Optional<ProductDao> productDao = productRepository.findById(request.getProductId());
        StockDao stockDao = StockDao.builder()
                .product(productDao.get())
                .quantity(request.getQuantity())
                .build();
        stockRepository.save(stockDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",stockDao, HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteStock(Long id) {
        stockRepository.deleteById(id);
        return ResponseUtil.build( AppConstant.ResponseCode.SUCCESS,"SUCCESS", null,HttpStatus.OK);
    }
}
