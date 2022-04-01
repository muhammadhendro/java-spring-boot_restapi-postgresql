package com.hendro.alterra.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Table(name="M_product")
public class ProductDao {


    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDao category;
//

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandDao brand;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private StockDao stock;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String productName;

    private String modelYear;

    private Integer listPrice;
}

