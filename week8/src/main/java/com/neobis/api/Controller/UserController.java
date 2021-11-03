package com.neobis.api.Controller;

import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private MyUserDetailsService service;

    @Autowired
    public void setService(MyUserDetailsService service) {
        this.service = service;
    }

    @GetMapping()
    public String getUser() {
        return "<h1>User<h1>";
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

/*    //Test method
    @GetMapping("/name/{firstName}")
    public ResponseEntity<?> getUserByFirstName(@PathVariable String firstName){
        try {
            return new ResponseEntity<>(service.getUserByFirstName(firstName), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }
    }

*/
}
