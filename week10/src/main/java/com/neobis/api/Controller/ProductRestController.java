package com.neobis.api.Controller;

import com.neobis.api.Entity.Product;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.ProductModel;
import com.neobis.api.Service.Impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    ProductServiceImpl service;

    @ApiOperation(value = "Get all products")
    @GetMapping("/all")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get product by id")
    @GetMapping("/id{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @ApiOperation(value = "Add product")
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.create(product), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edit product by id")
    @PutMapping("/id{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductModel productModel){
        try {
            return new ResponseEntity<>(service.updateById(id, productModel), HttpStatus.CREATED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @ApiOperation(value = "Delete product by id")
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
