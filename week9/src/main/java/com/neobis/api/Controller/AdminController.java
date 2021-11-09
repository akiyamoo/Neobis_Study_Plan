package com.neobis.api.Controller;

import com.neobis.api.Service.MyUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @ApiOperation(value = "Get admin page")
    @GetMapping("")
    public String getAdmin() {
        return "<h1>Admin<h1>";
    }

    @ApiOperation(value = "Get all users")
    @GetMapping("/all_users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(myUserDetailsService.getAll(), HttpStatus.OK);
    }

}
