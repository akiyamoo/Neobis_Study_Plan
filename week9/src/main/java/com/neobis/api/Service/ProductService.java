package com.neobis.api.Service;

import com.neobis.api.Entity.Product;
import com.neobis.api.Model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel getById(Integer id);

    ProductModel create(Product product);

    ProductModel updateById(Integer id, ProductModel productModel);

    void DeleteById(Integer id);

    List<?> getAll();

    ProductModel toModel(Product product);
}
