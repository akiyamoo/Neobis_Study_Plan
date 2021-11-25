package com.neobis.api.Service.Impl;

import com.neobis.api.Entity.Brand;
import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.BrandModel;
import com.neobis.api.Model.CategoryModel;
import com.neobis.api.Repository.BrandRepository;
import com.neobis.api.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    BrandRepository repository;

    @Autowired
    public BrandServiceImpl(BrandRepository repository){
        this.repository = repository;
    }

    public Brand toEntity(BrandModel brandModel){
        Brand brand = new Brand();

        brand.setId(brandModel.getId());
        brand.setName(brandModel.getName());
        brand.setDescription(brandModel.getDescription());

        return brand;
    }


    public List<BrandModel> getAll() {
        Iterable<Brand> brands = repository.findAll();
        List<BrandModel> brandModels = new ArrayList<>();

        for (Brand brand : brands){
            brandModels.add(toModel(brand));
        }

        return brandModels;
    }

    public BrandModel getById(Integer id) {
        return toModel(repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id)));
    }

    public BrandModel create(Brand brand) {
        return toModel(repository.save(brand));
    }

    public BrandModel updateById(Integer id, BrandModel brandModel) {
        Brand brand = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));

        //brand.setId(brandModel.getId());
        brand.setName(brandModel.getName());
        brand.setDescription(brand.getDescription());

        return toModel(repository.save(brand));
    }

    public void deleteById(Integer id) {
        Brand brand = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id));
        repository.delete(brand);
    }

    public BrandModel toModel(Brand brand){
        BrandModel brandModel = new BrandModel();

        brandModel.setId(brand.getId());
        brandModel.setName(brand.getName());
        brandModel.setDescription(brand.getDescription());

        return brandModel;
    }
}
