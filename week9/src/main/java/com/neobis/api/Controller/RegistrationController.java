package com.neobis.api.Controller;

import com.neobis.api.Model.UserRegistrationModel;
import com.neobis.api.Service.MyUserDetailsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @ApiOperation(value = "Get registration page")
    @GetMapping()
    public String getRegistrationPage() {
        return "registration";
    }

    @ApiOperation(value = "Post request for registration page")
    @PostMapping()
    public String registration(
            @ModelAttribute("userRegistration") UserRegistrationModel userRegistrationModel
    ) {

        myUserDetailsService.createUser(userRegistrationModel);

        return "redirect:/registration?success";
    }

    @ApiOperation(value = "Get Model object")
    @ModelAttribute("userRegistration")
    public UserRegistrationModel getUser() {
        return new UserRegistrationModel();
    }

}
