package com.neobis.api.Model;

import com.neobis.api.Entity.Brand;
import lombok.Getter;

@Getter
public class BrandModel {

    private Integer id;
    private String name;
    private String description;

    public BrandModel(){}

    public BrandModel(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public BrandModel(Brand brand){
        this.id = brand.getId();
        this.name = brand.getName();
        this.description = brand.getDescription();
    }
}
