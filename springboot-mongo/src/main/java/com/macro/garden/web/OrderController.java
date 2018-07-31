package com.macro.garden.web;

import com.macro.garden.domain.Order;
import com.macro.garden.repository.OrderRepository;
import com.mongodb.BasicDBObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by macro on 2018/7/27.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody Order order) {
        orderRepository.save(order);
        return "success";
    }

    @RequestMapping(value = "/aggByDate", method = RequestMethod.POST)
    @ResponseBody
    public Object aggByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 0, 1);
        Date start = calendar.getTime();
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.project("purchaseDate")
                        .and("purchaseDate").extractYear().as("year")
                        .and("purchaseDate").extractMonth().as("month"),
                Aggregation.match(Criteria.where("purchaseDate").gte(start)),
                Aggregation.group("year","month").count().as("count"));
        // TODO: 2018/7/30 没法运行
        AggregationResults<BasicDBObject> aggregationResults = mongoTemplate.aggregate(aggregation, Order.class, BasicDBObject.class);
        return aggregationResults.getMappedResults();
    }

    @ApiOperation("找到曼哈顿市最好的客户")
    @RequestMapping(value = "/aggByAmount", method = RequestMethod.POST)
    @ResponseBody
    public Object aggByAmount() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("shippingAddress.zip").gte(10019).lt(10040)),
                Aggregation.group("userId").sum("subTotal").as("total"),
                Aggregation.match(Criteria.where("total").gte(100)),
                Aggregation.sort(new Sort(Sort.Direction.DESC, "total")));
        AggregationResults<BasicDBObject> aggregationResults = mongoTemplate.aggregate(aggregation, Order.class, BasicDBObject.class);
        return aggregationResults.getMappedResults();
    }

    @ApiOperation("添加商品到购物车")
    @RequestMapping(value = "/addCart/{userId}",method = RequestMethod.POST)
    @ResponseBody
    public Object addToCart(@PathVariable String userId, @RequestBody Order.LineItem cartItem){
        //判断是否有购物车，没有就重新创建购物车
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId)
                        .and("state").is("CART"));
        Update update = new Update();
        update.inc("subTotal",cartItem.getPricing().getSale());
        mongoTemplate.upsert(query,update,Order.class);
        //判断购物车中是否有该商品，没有该商品则添加
        query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId)
                .and("state").is("CART")
                .and("lineItems._id").ne(cartItem.getId()));
        update = new Update();
        update.push("lineItems",cartItem);
        mongoTemplate.updateFirst(query,update,Order.class);
        //购物车中有该商品时，增加商品数量
        query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId)
                .and("state").is("CART")
                .and("lineItems._id").is(cartItem.getId()));
        update = new Update();
        update.inc("lineItems.$.quantity",1);
        mongoTemplate.updateFirst(query,update,Order.class);
        return "success";
    }

}
