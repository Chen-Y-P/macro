package com.macro.garden.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public class Review {

    /**
     * id : 4c4b1476238d3b4dd5000044
     * productId : 4c4b1476238d3b4dd5003982
     * userId : 4c4b1476238d3b4dd5000002
     * rating : 4
     * helpfulVotes : 1
     */
    @Id
    private String id;
    private String productId;
    private String userId;
    private String username;
    private int rating;
    private int helpfulVotes;
    private List<String> voterIds;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHelpfulVotes() {
        return helpfulVotes;
    }

    public void setHelpfulVotes(int helpfulVotes) {
        this.helpfulVotes = helpfulVotes;
    }

    public List<String> getVoterIds() {
        return voterIds;
    }

    public void setVoterIds(List<String> voterIds) {
        this.voterIds = voterIds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
