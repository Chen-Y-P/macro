package com.macro.garden.web;

import com.macro.garden.domain.Review;
import com.macro.garden.repository.ReviewRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody Review review) {
        reviewRepository.save(review);
        return "success";
    }

    @ApiOperation("根据商品id分页,根据点赞降序排列")
    @RequestMapping(value = "/list/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getList(@PathVariable String productId,
                          @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                          @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "helpfulVotes");
        PageRequest pageRequest = new PageRequest(pageNum, pageSize, sort);
        return reviewRepository.findByProductId(productId, pageRequest);
    }

    @ApiOperation("用户评论点赞")
    @RequestMapping(value = "/update/helpful", method = RequestMethod.POST)
    @ResponseBody
    public Object markHelpful(String voterId, String reviewId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(reviewId).and("voterIds").ne(voterId));
        Update update = new Update();
        update.push("voterIds",voterId);
        update.inc("helpfulVotes", 1);
        return  mongoTemplate.updateFirst(query, update, Review.class);
    }
}
