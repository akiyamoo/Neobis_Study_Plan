package com.neobis.api.Controller;

import com.neobis.api.Model.UserRegistrationModel;
import com.neobis.api.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public void setUserService(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping()
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping()
    public String registration(
            @ModelAttribute("userRegistration") UserRegistrationModel userRegistrationModel
    ) {

        myUserDetailsService.createUser(userRegistrationModel);

        return "redirect:/registration?success";
    }

    @ModelAttribute("userRegistration")
    public UserRegistrationModel getUser() {
        return new UserRegistrationModel();
    }

}
