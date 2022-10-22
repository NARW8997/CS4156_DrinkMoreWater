package com.cs4256.drinkmorewater.services;

import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant getRestaurantById(int restId) throws Exception {
        Optional<Restaurant> result = restaurantRepository.findById(restId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("specified restaurant not found!");
        }
    }
}
