package com.neobis.api.Service.Impl;

import com.neobis.api.Config.JWT.JwtProvider;
import com.neobis.api.Entity.Role;
import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Exception.UserUnauthorizedException;
import com.neobis.api.Model.UserAuthModel;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Model.UserRegistrationModel;
import com.neobis.api.Repository.RoleRepository;
import com.neobis.api.Repository.UserRepository;
import com.neobis.api.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("DetailsServices")
public class UserServiceImpl implements MyUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public String getUserAuthenticationToken(UserAuthModel userAuthModel) {
        UserAuthModel userEntity = findByUsernameAndPassword(userAuthModel.getUsername(), userAuthModel.getPassword());
        return jwtProvider.generateToken(userEntity.getUsername());
    }

    public UserAuthModel findByUsername(String login) {
        User user = userRepository.findByUsername(login);
        if (user == null) {
            throw new UserUnauthorizedException("Invalid username or password");
        }
        UserAuthModel userModel = new UserAuthModel();
        userModel.setUsername(user.getUsername());
        userModel.setPassword(user.getPassword());

        return userModel;
    }

    public UserAuthModel findByUsernameAndPassword(String login, String password) {
        UserAuthModel userEntity = findByUsername(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    @Override
    public void createUser(UserRegistrationModel userRegistration) {
        User user = userRepository.findByUsername(userRegistration.getUsername());

        if (user != null) {
            throw new UsernameNotFoundException("This username is exist");
        }

        user = new User();

        user.setUsername(userRegistration.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        user.addRoles(role);

        userRepository.save(user);

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return user;
    }

    @Override
    public List<UserModel> getAll() {
        Iterable<User> users = userRepository.findAll();
        List<UserModel> userModels = new ArrayList<>();

        for (User user : users){
            userModels.add(toModel(user));
        }

        return userModels;
    }

    @Override
    public UserModel toModel(User user){
        UserModel userModel = new UserModel();

        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());

        return userModel;
    }

    @Override
    public UserModel getUserById(Integer id) {
        return toModel(userRepository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id)));
    }
/*
    public UserModel updateById(Integer id, UserModel userModel) {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id));

        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());

        return toModel(repository.save(user));
    }

    public void deleteById(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id));
        repository.delete(user);
    }

    public UserModel getUserByFirstName(String firstName) {
        return toModel(repository.findByFirstName(firstName));
    }*/
}
