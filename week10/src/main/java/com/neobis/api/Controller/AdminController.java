package com.neobis.api.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @ApiOperation(value = "Get admin page")
    @GetMapping("")
    public String getAdmin() {
        return "<h1>Admin<h1>";
    }

}
