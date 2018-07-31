package com.macro.garden.repository;

import com.macro.garden.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public interface ReviewRepository extends MongoRepository<Review,String> {
    List<Review> findByProductId(String productId);
    Page<Review> findByProductId(String productId, Pageable pageable);
}
