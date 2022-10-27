package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
import com.cs4256.drinkmorewater.models.RestaurantPopular;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.services.IRestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RestaurantServiceImpl extends ServiceImpl<RestaurantMapper, Restaurant>
        implements IRestaurantService {
    @Autowired
    RestaurantMapper restaurantMapper;

    @Autowired
    ReviewMapper reviewMapper;

    public List<RestaurantPopular> getPopularRestaurants() {
        List<Restaurant> rests = restaurantMapper.selectList(null);
        List<RestaurantPopular> popRests = new ArrayList<>(rests.size());

        for (Restaurant r: rests) {
            RestaurantPopular popRest = new RestaurantPopular();
            QueryWrapper<Review> qw = new QueryWrapper<Review>();
            qw.ge("rest_id", r.getRestId());

            BeanUtils.copyProperties(r, popRest);

            int reviewCount = reviewMapper.selectCount(qw);
            popRest.setReviews(reviewCount);

            int likes = r.getRestLikes();
            int dislikes = r.getRestDislikes();
            popRest.setTotalLikes(likes - dislikes);

            popRests.add(popRest);
        }

        popRests.stream().sorted(
                Comparator.comparingInt(RestaurantPopular::getTotalLikes).reversed()
                        .thenComparing(RestaurantPopular::getReviews).reversed());

        return  popRests;
    }
}
