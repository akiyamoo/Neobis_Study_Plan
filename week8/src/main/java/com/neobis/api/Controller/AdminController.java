package com.neobis.api.Controller;

import com.neobis.api.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void setService(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping("")
    public String getAdmin() {
        return "<h1>Admin<h1>";
    }

    @GetMapping("/all_users")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(myUserDetailsService.getAll(), HttpStatus.OK);
    }

}
