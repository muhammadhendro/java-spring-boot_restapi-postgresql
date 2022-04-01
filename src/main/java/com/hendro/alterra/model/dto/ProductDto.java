package com.hendro.alterra.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -3016695005946898653L;

    private Long brandId;
    private Long categoryId;

    private String productName;



    private String modelYear;

    private Integer listPrice;
}

