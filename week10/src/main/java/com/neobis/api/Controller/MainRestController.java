package com.neobis.api.Controller;

import com.neobis.api.Config.JWT.JwtProvider;
import com.neobis.api.Model.UserAuthModel;
import com.neobis.api.Service.Impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/auth")
    @ApiOperation(value = "Authentication Rest API")
    public String auth(@RequestBody UserAuthModel userModel) {
        System.out.println(userModel.getUsername());
        UserAuthModel userEntity = userService.findByLoginAndPassword(userModel.getUsername(), userModel.getPassword());
        return jwtProvider.generateToken(userEntity.getUsername());
    }
}
