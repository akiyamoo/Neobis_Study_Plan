package com.neobis.api.Service;

import com.neobis.api.Entity.Category;
import com.neobis.api.Model.CategoryModel;

import java.util.List;

public interface CategoryService {

    Category toEntity(CategoryModel categoryModel);

    List<?> getAll();

    CategoryModel toModel(Category category);

    CategoryModel getById(Integer id);

    CategoryModel create(Category category);

    CategoryModel updateById(Integer id, CategoryModel categoryModel);

    void DeleteById(Integer id);

}
