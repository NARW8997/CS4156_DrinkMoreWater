package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.DishMapper;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.*;
import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
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
    private DishMapper dishMapper;

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

    @Override
    public List<RestaurantDetail> selectAllRestDetail() {
        List<RestaurantDetail> restaurantDetails = new ArrayList<>();
        for (Restaurant restaurant : restaurantMapper.selectList(null)) {
            int restId = restaurant.getRestId();
            restaurantDetails.add(selectRestDetailById(restId));
        }
        return restaurantDetails;
    }

    @Override
    public RestaurantDetail selectRestDetailById(Integer restId) {
        // get all the dishes where it's rest_id = restId
//        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
//        dishQueryWrapper.select(Dish::getDishName)
//                .eq(Dish::getRestId, restId);
//        List<String> dishName = new ArrayList<>();
//        for (Dish dish : dishMapper.selectList(dishQueryWrapper)) {
//            dishName.add(dish.getDishName());
//        }
//
//        // get all the reviews where it's rest_id = restId
//        LambdaQueryWrapper<Review> reviewQueryWrapper = new LambdaQueryWrapper<>();
//        reviewQueryWrapper.select(Review::getContent)
//                .eq(Review::getRestId, restId);
//        List<String> contents = new ArrayList<>();
//        for (Review review : reviewMapper.selectList(reviewQueryWrapper)) {
//            contents.add(review.getContent());
//        }
//
//        // Construct RestaurantDetails obj
//        Restaurant rest = restaurantMapper.selectById(restId);
//        RestaurantDetail restaurantDetail = new RestaurantDetail();
//        restaurantDetail.setRestId(rest.getRestId());
//        restaurantDetail.setRestLocation(rest.getRestLocation());
//        restaurantDetail.setRestName(rest.getRestName());
//        restaurantDetail.setRestLikes(rest.getRestLikes());
//        restaurantDetail.setRestDislikes(rest.getRestDislikes());
//        restaurantDetail.setRestNumber(rest.getRestNumber());
//        restaurantDetail.setRestSize(rest.getRestSize());
//        restaurantDetail.setContents(contents);
//        restaurantDetail.setDishes(dishName);
//        return restaurantDetail;
        List<String> reviews = restaurantMapper.selectReviewContentByRestId(restId);
        List<String> dishes = restaurantMapper.selectDishNameByRestId(restId);
        RestaurantDetail restaurantDetail = restaurantMapper.selectRestDetailById(restId);
        restaurantDetail.setContents(reviews);
        restaurantDetail.setDishes(dishes);
        return restaurantDetail;
    }

    @Override
    public Integer updateRestLikesByRestId(Integer restLikes, Integer restId) {
        return restaurantMapper.updateRestLikesByRestId(restLikes, restId);
    }

    @Override
    public Integer updateRestDislikesByRestId(Integer restDislikes, Integer restId) {
        return restaurantMapper.updateRestDislikesByRestId(restDislikes, restId);
    }

    @Override
    public Integer updateRestLikesByRestIdBy1(Integer restId) {
        return restaurantMapper.updateRestLikesByRestIdBy1(restId);
    }

    @Override
    public Integer updateRestDislikesByRestIdBy1(Integer restId) {
        return restaurantMapper.updateRestDislikesByRestIdBy1(restId);
    }

    @Override
    public Integer insertExceptLikeAndDislike(Restaurant restaurant) {
        return restaurantMapper.insertExceptLikeAndDislike(restaurant);
    }

    @Override
    public Integer updateExceptLikeAndDislike(Restaurant restaurant) {
        return restaurantMapper.updateExceptLikeAndDislike(restaurant);
    }

    @Override
    public List<TopRankDish> getTopRankOrderedDishesByRestId(Integer restId, Integer rank) {
        return restaurantMapper.selectTopRankOrderedDishesByRestId(restId, rank);
    }


}
