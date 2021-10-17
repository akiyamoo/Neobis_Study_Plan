package com.neobis.api.Controller;

import com.neobis.api.Entity.Brand;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.BrandModel;
import com.neobis.api.Service.BrandService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {

    BrandService service;

    @Autowired
    public BrandController(BrandService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBrands(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBrand(@RequestBody Brand brand){
        return new ResponseEntity<>(service.create(brand), HttpStatus.CREATED);
    }

    @PutMapping("/id{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Integer id, @RequestBody BrandModel brandModel){
        try {
            return new ResponseEntity<>(service.updateById(id, brandModel), HttpStatus.CREATED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @DeleteMapping("/id{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer id){
        try {
            service.deleteById(id);
            return new ResponseEntity<>("Deleted brand with id =" + id, HttpStatus.ACCEPTED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }
}
