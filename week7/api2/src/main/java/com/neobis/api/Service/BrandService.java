package com.neobis.api.Service;

import com.neobis.api.Entity.Brand;
import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.BrandModel;
import com.neobis.api.Model.CategoryModel;
import com.neobis.api.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    BrandRepository repository;

    @Autowired
    public BrandService(BrandRepository repository){
        this.repository = repository;
    }

    public List<BrandModel> getAll() {
        Iterable<Brand> brands = repository.findAll();
        List<BrandModel> brandModels = new ArrayList<>();

        for (Brand brand : brands){
            brandModels.add(new BrandModel(brand));
        }

        return brandModels;
    }

    public BrandModel getById(Integer id) {
        return new BrandModel(repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id)));
    }

    public BrandModel create(Brand brand) {
        return new BrandModel(repository.save(brand));
    }

    public BrandModel updateById(Integer id, BrandModel brandModel) {
        Brand brand = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));

        //brand.setId(brandModel.getId());
        brand.setName(brandModel.getName());
        brand.setDescription(brand.getDescription());

        return new BrandModel(repository.save(brand));
    }

    public void deleteById(Integer id) {
        Brand brand = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id));
        repository.delete(brand);
    }

/*    public BrandModel toModel(Brand brand){
        return new BrandModel(brand);
    }*/
}
