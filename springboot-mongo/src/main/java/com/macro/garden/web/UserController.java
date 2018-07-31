package com.macro.garden.web;

import com.macro.garden.domain.User;
import com.macro.garden.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by macro on 2018/7/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody User user) {
        userRepository.save(user);
        return "success";
    }

    @RequestMapping(value = "/get/zip", method = RequestMethod.GET)
    @ResponseBody
    public Object getByZip(Integer startZip, Integer endZip) {
        Query query = new Query();
        Criteria criteria = Criteria.where("addresses.zip").gte(startZip).lte(endZip);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @ApiOperation("查询子数组中部分满足的文档")
    @RequestMapping(value = "/getByAddressPart", method = RequestMethod.GET)
    @ResponseBody
    public Object getByAddressPart(String name, String state) {
        Query query = new Query();
        Criteria criteria = Criteria.where("addresses.name").is(name).and("addresses.state").is(state);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @ApiOperation("查询子数组中同时满足的文档")
    @RequestMapping(value = "/getByAddress", method = RequestMethod.GET)
    @ResponseBody
    public Object getByAddress(String name, String state) {
        Query query = new Query();
        Criteria criteria = Criteria.where("addresses").elemMatch(Criteria.where("name").is(name).and("state").is(state));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, User.class);
    }

    @ApiOperation("根据id修改email")
    @RequestMapping(value = "/updateEmail/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable String userId, String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(userId));
        return mongoTemplate.updateFirst(query,Update.update("email",email),User.class);
    }
}
