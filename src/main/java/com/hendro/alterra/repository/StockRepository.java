package com.hendro.alterra.repository;

import com.hendro.alterra.model.dao.StockDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockDao, Long> {
}

