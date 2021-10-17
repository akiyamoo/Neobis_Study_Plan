package com.neobis.api.Model;

import com.neobis.api.Entity.Category;
import lombok.Getter;

@Getter
public class CategoryModel {

    private Integer id;
    private String name;

    public CategoryModel() {}

    public CategoryModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryModel(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
