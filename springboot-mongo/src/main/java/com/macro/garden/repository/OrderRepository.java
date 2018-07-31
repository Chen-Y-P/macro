package com.macro.garden.repository;

import com.macro.garden.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by macro on 2018/7/27.
 */
public interface OrderRepository extends MongoRepository<Order,String> {
}
