package com.neobis.api.Controller;

import com.neobis.api.Exception.UserUnauthorizedException;
import com.neobis.api.Service.MyUserDetailsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @ApiOperation(value = "Get current admin")
    @GetMapping("")
    public ResponseEntity<String> getAdmin() {
        return new ResponseEntity<>("admin", HttpStatus.OK);
    }

    @ApiOperation(value = "Get all users")
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(myUserDetailsService.getAll(), HttpStatus.OK);
    }

}
