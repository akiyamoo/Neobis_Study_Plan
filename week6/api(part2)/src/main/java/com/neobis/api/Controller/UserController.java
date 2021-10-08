package com.neobis.api.Controller;


import com.neobis.api.Entity.User;
import com.neobis.api.Exception.UserNotFoundException;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        return ResponseEntity.ok(service.saveModel(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserModel userModel, @PathVariable Integer id){
        try{
            return service.updateModel(id, userModel);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
        try {
            return service.getModel(id);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        try {
            return service.getAllModel();
        }
        catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        return service.deleteModel(id);
    }

}
