package com.neobis.api.Controller;

import com.neobis.api.Model.UserRegistrationModel;
import com.neobis.api.Service.Impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class RegistrationRestController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("")
    @ApiOperation(value = "Registration User on Rest API")
    public ResponseEntity<?> registration(@RequestBody UserRegistrationModel userRegistrationModel) {
        try {
          userService.createUser(userRegistrationModel);

          return new ResponseEntity<String>("Registration success", HttpStatus.CREATED);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
