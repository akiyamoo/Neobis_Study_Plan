package com.neobis.api.Service;

import com.neobis.api.Entity.User;
import com.neobis.api.Exception.NotFoundException;
import com.neobis.api.Model.UserModel;
import com.neobis.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<UserModel> getAll() {
        Iterable<User> users = repository.findAll();
        List<UserModel> userModels = new ArrayList<>();

        for (User user : users){
            userModels.add(toModel(user));
        }

        return userModels;
    }

    public UserModel toModel(User user){
        return new UserModel(user.getId(), user.getFirstName(), user.getLastName());
    }

    public UserModel getUserById(Integer id) {
        return toModel(repository.findById(id).orElseThrow(() -> new NotFoundException("Don't have user - " + id)));
    }


    public UserModel create(User user) {
        return toModel(repository.save(user));
    }

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
    }
}
