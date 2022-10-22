package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("user_id") int userId) {
        try {
            User resUser = userService.getUserById(userId);

            return new ResponseEntity<>(resUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error happened when getting user by id");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
