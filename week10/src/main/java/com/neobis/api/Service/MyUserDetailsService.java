package com.neobis.api.Service;

import com.neobis.api.Entity.User;
import com.neobis.api.Model.UserAuthModel;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Model.UserRegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MyUserDetailsService extends UserDetailsService {

    UserRegistrationModel createUser(UserRegistrationModel userRegistration);

    List<UserModel> getAll();

    UserModel toModel(User user);

    UserModel getUserById(Integer id);

    public UserAuthModel findByLogin(String login);

    public UserAuthModel findByLoginAndPassword(String login, String password);
}
