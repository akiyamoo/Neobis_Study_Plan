package com.neobis.api.Service;

import com.neobis.api.Entity.Category;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.CategoryModel;
import com.neobis.api.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public Category toEntity(CategoryModel categoryModel){
        Category category = new Category();

        category.setId(categoryModel.getId());
        category.setName(categoryModel.getName());

        return category;
    }

    public List<?> getAll() {
        Iterable<Category> categories = repository.findAll();
        List<CategoryModel> categoryModels = new ArrayList<>();

        for (Category category : categories){
            categoryModels.add(toModel(category));
        }

        return categoryModels;
    }

    public CategoryModel toModel(Category category){
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId(category.getId());
        categoryModel.setName(category.getName());

        return categoryModel;
    }

    public CategoryModel getById(Integer id) {
        return toModel(repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id)));
    }

    public CategoryModel create(Category category) {
        return toModel(repository.save(category));
    }


    public CategoryModel updateById(Integer id, CategoryModel categoryModel) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));

        //category.setId(category.getId());
        category.setName(categoryModel.getName());

        return toModel(repository.save(category));
    }

    public void DeleteById(Integer id) {
        Category category = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));
        repository.delete(category);
    }

}
