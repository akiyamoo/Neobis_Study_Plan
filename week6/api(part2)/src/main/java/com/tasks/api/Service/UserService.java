package com.tasks.api.Service;

import com.tasks.api.Entity.User;
import com.tasks.api.Exception.UserNotFoundException;
import com.tasks.api.Model.UserModel;
import com.tasks.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserModel saveModel(User user) {
        return toModel(repository.save(user));
    }

    public static List<UserModel> toModels(Iterable<User> users)
    {
        List<UserModel> userModelList = new ArrayList<>();

        for (User user : users)
        {
            userModelList.add(toModel(user));
        }
        return userModelList;
    }


    public static UserModel toModel(User user){
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());

        return userModel;
    }


    public ResponseEntity<?> updateModel(Integer id, UserModel userModel) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());

        return new ResponseEntity(toModel(repository.save(user)), HttpStatus.OK);

    }

    public ResponseEntity<?> getModel(Integer id) {
        User user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        return new ResponseEntity<>(toModel(user), HttpStatus.OK);
    }

    public ResponseEntity<?> getAllModel(){
        return new ResponseEntity<>(toModels(repository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteModel(Integer id) {

        try {
            repository.deleteById(id);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), e.getSTATUS());
        }

        return new ResponseEntity<>("Delete Id = " + id, HttpStatus.OK);
    }
}
