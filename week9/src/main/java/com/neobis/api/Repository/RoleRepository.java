package com.neobis.api.Repository;

import com.neobis.api.Entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
