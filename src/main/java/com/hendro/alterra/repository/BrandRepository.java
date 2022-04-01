package com.hendro.alterra.repository;

import com.hendro.alterra.model.dao.BrandDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandDao, Long> {
}