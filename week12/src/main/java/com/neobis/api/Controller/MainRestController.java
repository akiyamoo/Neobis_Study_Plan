package com.neobis.api.Controller;

import com.neobis.api.Exception.UserUnauthorizedException;
import com.neobis.api.Model.AuthResponse;
import com.neobis.api.Model.UserAuthModel;
import com.neobis.api.Service.Impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/auth")
    @ApiOperation(value = "Authentication Rest API")
    public ResponseEntity<?> auth(@RequestBody UserAuthModel userModel) {
        try {
            AuthResponse response = new AuthResponse();
            response.setToken(userService.getUserAuthenticationToken(userModel));

            return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
        } catch (UserUnauthorizedException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getSTATUS());
        }
    }
}
