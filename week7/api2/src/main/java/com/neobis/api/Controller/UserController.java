package com.neobis.api.Controller;

import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/id{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    //Test method
    @GetMapping("/name/{firstName}")
    public ResponseEntity<?> getUserByFirstName(@PathVariable String firstName){
        try {
            return new ResponseEntity<>(service.getUserByFirstName(firstName), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/id{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserModel userModel){
        try {
            return new ResponseEntity<>(service.updateById(id, userModel), HttpStatus.CREATED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @DeleteMapping("/id{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        try {
            service.deleteById(id);
            return new ResponseEntity<>("Deleted user with id = " + id, HttpStatus.ACCEPTED);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }
}
