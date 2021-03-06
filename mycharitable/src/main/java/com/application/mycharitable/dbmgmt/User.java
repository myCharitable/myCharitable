package com.application.mycharitable.dbmgmt;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "users")
public class User {

    @Id
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String ebtNumber;
    private String shoppingCart;

    public String getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(String shoppingCart) {
        this.shoppingCart = shoppingCart;
    }



    public User() {

    }

    public User(String email, String password, String fName, String lName, String phoneNumber, String ebtNumber) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.ebtNumber = ebtNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getFName() { return fName; }

    public void setFName(String fName) { this.fName = fName; }

    public String getLName() { return lName; }

    public void setLName(String lName) { this.lName = lName; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEbtNumber() {
        return ebtNumber;
    }

    public void setEbtNumber(String ebtNumber) {
        this.ebtNumber = ebtNumber;
    }


}
