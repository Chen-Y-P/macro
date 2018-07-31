package com.macro.garden.web;

import com.macro.garden.domain.Category;
import com.macro.garden.domain.Product;
import com.macro.garden.domain.Review;
import com.macro.garden.repository.CategoryRepository;
import com.macro.garden.repository.ProductRepository;
import com.macro.garden.repository.ReviewRepository;
import com.mongodb.BasicDBObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by macro on 2018/7/27.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody Product product) {
        productRepository.save(product);
        return "success";
    }

    @RequestMapping(value = "/get/detail/{slug}", method = RequestMethod.GET)
    @ResponseBody
    public Object getDetail(@PathVariable String slug) {
        Product product = productRepository.findBySlug(slug);
        Category category = categoryRepository.findOne(product.getMainCatId());
        List<Review> reviews = reviewRepository.findByProductId(product.getId());
        Map<String, Object> result = new TreeMap<>();
        result.put("product", product);
        result.put("category", category);
        result.put("reviews", reviews);
        return result;
    }

    @RequestMapping(value = "/getByColors", method = RequestMethod.POST)
    @ResponseBody
    public Object getItem(@RequestParam("colors") List<String> colors) {
        Query query = new Query();
        Criteria criteria = Criteria.where("details.color").in(colors);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Product.class);
    }

    @ApiOperation("获取指定商品的评论数及平均评分")
    @RequestMapping(value = "/agg/reviewCount/{slug}", method = RequestMethod.GET)
    @ResponseBody
    public Object aggReviewCount(@PathVariable String slug) {
        Product product = productRepository.findBySlug(slug);
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("productId").is(product.getId())),
                Aggregation.group("productId").count().as("count")
                        .avg("rating").as("average"));
        AggregationResults<BasicDBObject> outTypeResults = mongoTemplate.aggregate(aggregation, Review.class, BasicDBObject.class);
        return outTypeResults.getMappedResults();
    }

    @ApiOperation("获取指定商品的评分统计")
    @RequestMapping(value = "/agg/reviewRating/{slug}", method = RequestMethod.GET)
    @ResponseBody
    public Object aggReviewRating(@PathVariable String slug) {
        Product product = productRepository.findBySlug(slug);
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("productId").is(product.getId())),
                Aggregation.group("rating").count().as("count"));
        AggregationResults<BasicDBObject> outTypeResults = mongoTemplate.aggregate(aggregation, Review.class, BasicDBObject.class);
        return outTypeResults.getMappedResults();
    }

    @ApiOperation("获取所有分类下的商品")
    @RequestMapping(value = "/agg/productByCat", method = RequestMethod.GET)
    @ResponseBody
    public Object aggProductByCat() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("mainCatId").count().as("count"));
        AggregationResults<BasicDBObject> outTypeResults = mongoTemplate.aggregate(aggregation, Product.class, BasicDBObject.class);
        for (BasicDBObject object : outTypeResults) {
            String mainCatId = (String) object.get("_id");
            Category category = categoryRepository.findOne(mainCatId);
            object.put("categoryName", category.getName());
        }
        return outTypeResults.getMappedResults();
    }

    @ApiOperation("获取所有分类下的商品")
    @RequestMapping(value = "/agg/productByCatIds", method = RequestMethod.GET)
    @ResponseBody
    public Object aggProductByCatIds() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.project("categoryIds"),
                Aggregation.unwind("categoryIds"),
                Aggregation.group("categoryIds").count().as("count"),
                Aggregation.out("countsByCategory"));
        mongoTemplate.aggregate(aggregation, Product.class, BasicDBObject.class);
        return mongoTemplate.findAll(BasicDBObject.class, "countsByCategory");
    }
}
