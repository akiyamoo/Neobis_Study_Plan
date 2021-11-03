package com.neobis.api.Controller;

import com.neobis.api.Entity.Category;
import com.neobis.api.Entity.Product;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.CategoryModel;
import com.neobis.api.Model.ProductModel;
import com.neobis.api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService service;

    @Autowired
    public void setService(ProductService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.create(product), HttpStatus.CREATED);
    }

    @PutMapping("/id{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody ProductModel productModel){
        try {
            return new ResponseEntity<>(service.updateById(id, productModel), HttpStatus.CREATED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @DeleteMapping("/id{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        try {
            service.DeleteById(id);
            return new ResponseEntity<>("Deleted product with id =" + id, HttpStatus.ACCEPTED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }
}
