package com.neobis.api.Repository;

import com.neobis.api.Entity.User;
import com.neobis.api.Model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
