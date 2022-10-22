package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restService;

    @RequestMapping(value = "/restaurant/{rest_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable("rest_id") int restId) {
        try {
            Restaurant restaurant = restService.getRestaurantById(restId);

            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error happened when getting restaurant by id");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
