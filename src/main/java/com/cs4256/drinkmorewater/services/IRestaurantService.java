package com.cs4256.drinkmorewater.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.RestaurantDetail;
import com.cs4256.drinkmorewater.models.TopRankDish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRestaurantService extends IService<Restaurant>  {
    List<RestaurantDetail> selectAllRestDetail();


    RestaurantDetail selectRestDetailById(Integer restId);

    Integer updateRestLikesByRestId(Integer restLikes, Integer restId);

    Integer updateRestDislikesByRestId(Integer restDislikes, Integer restId);

    Integer updateRestLikesByRestIdBy1(Integer restId);

    Integer updateRestDislikesByRestIdBy1(Integer restId);

    Integer insertExceptLikeAndDislike(Restaurant restaurant);

    Integer updateExceptLikeAndDislike(Restaurant restaurant);

    List<TopRankDish> getTopRankOrderedDishesByRestId(@Param("restId") Integer restId, @Param("rank") Integer rank);
}
