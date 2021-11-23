package com.neobis.api.Service;

import com.neobis.api.Entity.Brand;
import com.neobis.api.Model.BrandModel;

import java.util.List;

public interface BrandService {

    Brand toEntity(BrandModel brandModel);

    List<BrandModel> getAll();

    BrandModel getById(Integer id);

    BrandModel create(Brand brand);

    BrandModel updateById(Integer id, BrandModel brandModel);

    void deleteById(Integer id);

    BrandModel toModel(Brand brand);
}
