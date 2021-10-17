package com.neobis.api.Model;

import com.neobis.api.Entity.Brand;
import com.neobis.api.Entity.Category;
import lombok.Getter;

@Getter
public class ProductModel {

    private Integer id;
    private Brand brand;
    private Category category;
    private String productName;
    private String productSpecification;
    private String productDescription;

    public ProductModel(){}

    public ProductModel(Integer id, Brand brand, Category category, String productName, String productSpecification, String productDescription) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.productName = productName;
        this.productSpecification = productSpecification;
        this.productDescription = productDescription;
    }
}
