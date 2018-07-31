package com.macro.garden.repository;

/**
 * Created by macro on 2018/7/27.
 */

import com.macro.garden.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findBySlug(String slug);
}
