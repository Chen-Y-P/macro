package com.macro.garden.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public class Order {

    /**
     * id : 6a5b1476238d3b4dd5000048
     * userId : 4c4b1476238d3b4dd5000001
     * purchaseDate : 2014-08-01T07:00:00.000Z
     * state : CART
     * lineItems : [{"id":"4c4b1476238d3b4dd5003981","sku":"9092","name":"Extra Large Wheel Barrow","quantity":1,"pricing":{"retail":5897,"sale":4897}},{"id":"4c4b1476238d3b4dd5003982","sku":"10027","name":"Rubberized Work Glove, Black","quantity":1,"pricing":{"retail":1499,"sale":1299}}]
     * shippingAddress : {"street":"588 5th Street","city":"Brooklyn","state":"NY","zip":11215}
     * subTotal : 6196
     * tax : 600
     */
    @Id
    private String id;
    private String userId;
    private Date purchaseDate;
    private String state;
    private ShippingAddress shippingAddress;
    private int subTotal;
    private int tax;
    private List<LineItem> lineItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public static class ShippingAddress {
        /**
         * street : 588 5th Street
         * city : Brooklyn
         * state : NY
         * zip : 11215
         */

        private String street;
        private String city;
        private String state;
        private int zip;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getZip() {
            return zip;
        }

        public void setZip(int zip) {
            this.zip = zip;
        }
    }

    public static class LineItem {
        /**
         * id : 4c4b1476238d3b4dd5003981
         * sku : 9092
         * name : Extra Large Wheel Barrow
         * quantity : 1
         * pricing : {"retail":5897,"sale":4897}
         */

        private String id;
        private String sku;
        private String name;
        private int quantity;
        private Pricing pricing;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Pricing getPricing() {
            return pricing;
        }

        public void setPricing(Pricing pricing) {
            this.pricing = pricing;
        }

        public static class Pricing {
            /**
             * retail : 5897
             * sale : 4897
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
    }
}
