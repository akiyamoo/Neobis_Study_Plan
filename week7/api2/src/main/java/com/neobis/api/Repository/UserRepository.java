package com.neobis.api.Repository;

import com.neobis.api.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByFirstName(String firstName);
}
