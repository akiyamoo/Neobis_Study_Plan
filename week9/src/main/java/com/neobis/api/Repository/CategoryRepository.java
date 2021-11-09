package com.neobis.api.Repository;

import com.neobis.api.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
