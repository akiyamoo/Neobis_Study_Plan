package com.neobis.api.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "Get user page")
    @GetMapping()
    public String getUser() {
        return "<h1>User<h1>";
    }

}
