package com.neobis.api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private Integer id;
    private BrandModel brandModel;
    private CategoryModel categoryModel;
    private String productName;
    private String productSpecification;
    private String productDescription;

}
