package com.macro.garden.repository;

import com.macro.garden.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findBySlug(String slug);
}
