package com.neobis.api.Controller;

import com.neobis.api.Entity.Category;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.CategoryModel;
import com.neobis.api.Service.Impl.CategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    CategoryServiceImpl service;

    @ApiOperation(value = "Get all categories")
    @GetMapping("/all")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get category by id")
    @GetMapping("/id{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @ApiOperation(value = "Add category")
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        return new ResponseEntity<>(service.create(category), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Edit category by id")
    @PutMapping("/id{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryModel categoryModel){
        try {
            return new ResponseEntity<>(service.updateById(id, categoryModel), HttpStatus.CREATED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @ApiOperation(value = "Delete category by id")
    @DeleteMapping("/id{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
        try {
            service.DeleteById(id);
            return new ResponseEntity<>("Deleted category with id =" + id, HttpStatus.ACCEPTED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }
}
