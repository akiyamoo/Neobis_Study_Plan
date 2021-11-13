package com.neobis.api.Controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class MainController {

    @ApiOperation(value = "Get main page")
    @GetMapping("/")
    @ResponseBody
    public String getPage() { return "<h1>Welcome<h1>"; }

    @ApiOperation(value = "Get Swagger page")
    @GetMapping("/help")
    //@ResponseBody
    public String getSwaggerHelpPage() { return "redirect:/swagger-ui.html"; }

    @ApiOperation(value = "Get login page")
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @ApiOperation(value = "Get logout page")
    @GetMapping("/logout")
    public String getLogoutPage() {
        return "logout";
    }

}
