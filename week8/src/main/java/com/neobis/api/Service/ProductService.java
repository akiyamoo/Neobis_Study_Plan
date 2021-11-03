package com.neobis.api.Service;

import com.neobis.api.Entity.Product;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.ProductModel;
import com.neobis.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private BrandService brandService;
    private CategoryService categoryService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository, BrandService brandService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }

    public ProductModel getById(Integer id) {
        return toModel(productRepository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id)));
    }

    public ProductModel create(Product product) {
        return toModel(productRepository.save(product));
    }


    public ProductModel updateById(Integer id, ProductModel productModel) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));

        //product.setId(productModel.getId());
        product.setProductName(productModel.getProductName());
        product.setProductDescription(productModel.getProductDescription());
        product.setProductSpecification(productModel.getProductSpecification());
        product.setBrand(brandService.toEntity(productModel.getBrandModel()));
        product.setCategory(categoryService.toEntity(productModel.getCategoryModel()));

        return toModel(productRepository.save(product));
    }

    public void DeleteById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Don't have category - " + id));
        productRepository.delete(product);
    }

    public List<?> getAll() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductModel> productModels = new ArrayList<>();

        for (Product product : products){
            productModels.add(toModel(product));
        }

        return productModels;
    }

    public ProductModel toModel(Product product) {
        ProductModel productModel = new ProductModel();

        productModel.setId(product.getId());
        productModel.setProductName(product.getProductName());
        productModel.setProductDescription(productModel.getProductDescription());
        productModel.setBrandModel(brandService.toModel(product.getBrand()));
        productModel.setCategoryModel(categoryService.toModel(product.getCategory()));
        productModel.setProductSpecification(productModel.getProductSpecification());

        return productModel;
    }



}
