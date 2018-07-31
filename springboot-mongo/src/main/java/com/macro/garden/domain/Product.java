package com.macro.garden.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public class Product {
    @Id
    private String id;
    private String slug;
    private String sku;
    private String name;
    private String description;
    private ProductDetail details;
    private int totalReviews;
    private double averageReview;
    private ProductPrice pricing;
    private String mainCatId;
    private List<ProductPriceHistory> productPriceHistories;
    private List<String> categoryIds;
    private List<String> tags;

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDetail getDetails() {
        return details;
    }

    public void setDetails(ProductDetail details) {
        this.details = details;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public double getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(double averageReview) {
        this.averageReview = averageReview;
    }

    public ProductPrice getPricing() {
        return pricing;
    }

    public void setPricing(ProductPrice pricing) {
        this.pricing = pricing;
    }

    public String getMainCatId() {
        return mainCatId;
    }

    public void setMainCatId(String mainCatId) {
        this.mainCatId = mainCatId;
    }

    public List<ProductPriceHistory> getProductPriceHistories() {
        return productPriceHistories;
    }

    public void setProductPriceHistories(List<ProductPriceHistory> productPriceHistories) {
        this.productPriceHistories = productPriceHistories;
    }

    public List<String> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<String> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public static class ProductDetail {
        /**
         * weight : 5
         * weightUnits : oz
         * modelNum : 4039
         * manufacturer : GloveCo
         * color : black
         */

        private int weight;
        private String weightUnits;
        private int modelNum;
        private String manufacturer;
        private String color;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getWeightUnits() {
            return weightUnits;
        }

        public void setWeightUnits(String weightUnits) {
            this.weightUnits = weightUnits;
        }

        public int getModelNum() {
            return modelNum;
        }

        public void setModelNum(int modelNum) {
            this.modelNum = modelNum;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class ProductPrice {
        /**
         * retail : 1499
         * sale : 1299
         */

        private int retail;
        private int sale;

        public int getRetail() {
            return retail;
        }

        public void setRetail(int retail) {
            this.retail = retail;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }
    }

    public static class ProductPriceHistory {
        /**
         * retail : 1399
         * sale : 1199
         * start : 2010-05-01T07:00:00.000Z
         * end : 2010-05-08T07:00:00.000Z
         */

        private int retail;
        private int sale;
        private Date start;
        private Date end;

        public int getRetail() {
            return retail;
        }

        public void setRetail(int retail) {
            this.retail = retail;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }
    }
}
