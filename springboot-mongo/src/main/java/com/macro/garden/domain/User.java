package com.macro.garden.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public class User {

    /**
     * id : 4c4b1476238d3b4dd5000001
     * username : kbanker
     * email : kylebanker@gmail.com
     * firstName : Kyle
     * lastName : Banker
     * hashedPassword : bd1cfa194c3a603e7186780824b04419
     * addresses : [{"name":"home","street":"588 5th Street","city":"Brooklyn","state":"NY","zip":11215},{"name":"work","street":"1 E. 23rd Street","city":"New York","state":"NY","zip":10010}]
     * paymentMethods : [{"name":"VISA","lastFour":2127,"cryptedNumber":"43f6ba1dfda6b8106dc7","expirationDate":"2016-05-01T07:00:00.000Z"}]
     */
    @Id
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String hashedPassword;
    private List<Address> addresses;
    private List<PaymentMethod> paymentMethods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public static class Address {
        /**
         * name : home
         * street : 588 5th Street
         * city : Brooklyn
         * state : NY
         * zip : 11215
         */

        private String name;
        private String street;
        private String city;
        private String state;
        private int zip;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

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

    public static class PaymentMethod {
        /**
         * name : VISA
         * lastFour : 2127
         * cryptedNumber : 43f6ba1dfda6b8106dc7
         * expirationDate : 2016-05-01T07:00:00.000Z
         */

        private String name;
        private int lastFour;
        private String cryptedNumber;
        private Date expirationDate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLastFour() {
            return lastFour;
        }

        public void setLastFour(int lastFour) {
            this.lastFour = lastFour;
        }

        public String getCryptedNumber() {
            return cryptedNumber;
        }

        public void setCryptedNumber(String cryptedNumber) {
            this.cryptedNumber = cryptedNumber;
        }

        public Date getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
        }
    }
}
