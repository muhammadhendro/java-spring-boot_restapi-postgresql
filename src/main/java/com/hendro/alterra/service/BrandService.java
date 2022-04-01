package com.hendro.alterra.service;

import com.hendro.alterra.constant.AppConstant;
import com.hendro.alterra.model.dao.BrandDao;
import com.hendro.alterra.model.dto.BrandDto;
import com.hendro.alterra.repository.BrandRepository;
import com.hendro.alterra.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public ResponseEntity<Object> getAllBrand() {
        List<BrandDao> daoList = brandRepository.findAll();
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,"SUCCESS", daoList, HttpStatus.OK);
    }

    public ResponseEntity<Object> saveBrand(BrandDto request) {
        BrandDao brandDao = BrandDao.builder()
                .brandName(request.getBrandName())
                .build();
        brandRepository.save(brandDao);
        return ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, "SUCCESS",brandDao, HttpStatus.OK);
    }
}
