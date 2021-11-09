package com.neobis.api.Service.Impl;

import com.neobis.api.Entity.Role;
import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Model.UserRegistrationModel;
import com.neobis.api.Repository.RoleRepository;
import com.neobis.api.Repository.UserRepository;
import com.neobis.api.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("DetailsServices")
public class UserServiceImpl implements MyUserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public void setDependencies(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegistrationModel createUser(UserRegistrationModel userRegistration) {
        User user = userRepository.findByUsername(userRegistration.getUsername());

        if (user != null) {
            throw new UsernameNotFoundException("This username is exist");
        }

        user = new User();

        System.out.println(userRegistration.getUsername());
        System.out.println(userRegistration.getPassword());
        user.setUsername(userRegistration.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        user.addRoles(role);

        userRepository.save(user);

        return userRegistration;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
