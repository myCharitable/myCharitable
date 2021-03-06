package com.application.mycharitable.service;

import com.application.mycharitable.dbmgmt.User;
import com.application.mycharitable.repository.UserRepository;
import com.application.mycharitable.dbmgmt.User;
import com.application.mycharitable.repository.UserRepository;
import com.application.mycharitable.sms.SMSOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Create User
    public User createUser(String email, String password, String fName, String lName, String phoneNumber, String ebtNumber) {
        return userRepository.insert(new User(email, password, fName, lName, phoneNumber, ebtNumber));
    }

    //Retrieve User
    public User getUser(String email, String password) {
        User u;

        try {
            u = userRepository.findById(email).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "", e);
        }

        if (!password.equals(u.getPassword())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return u;
    }

    //setCart
    public User setCart(String email, boolean isLoggedIn, String shoppingCart) {

        if(isLoggedIn) {
            User u = userRepository.findById(email).get();
            u.setShoppingCart(shoppingCart);
            userRepository.save(u);
            SMSOut smsOut = new SMSOut();
            smsOut.sendConfirmation(u.getFName(), u.getPhoneNumber(), u.getShoppingCart());
            return u;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

    }

    //getCart
    public String getCart(String email) {
        return userRepository.findById(email).get().getShoppingCart();
    }
}