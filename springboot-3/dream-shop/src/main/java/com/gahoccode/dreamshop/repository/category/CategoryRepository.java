package com.gahoccode.dreamshop.repository.category;

import com.gahoccode.dreamshop.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {
    Category findByName(String name);
}
