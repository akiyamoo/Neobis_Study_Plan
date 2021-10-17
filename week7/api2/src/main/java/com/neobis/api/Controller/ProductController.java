package com.neobis.api.Controller;

import com.neobis.api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }
}
