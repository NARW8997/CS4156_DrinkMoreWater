package com.cs4256.drinkmorewater.mapper;
import java.util.List;

import com.cs4256.drinkmorewater.models.TopRankDish;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface RestaurantMapper extends BaseMapper<Restaurant> {
    Integer updateRestDislikesByRestId(@Param("restDislikes") Integer restDislikes, @Param("restId") Integer restId);

    Integer updateRestLikesByRestId(@Param("restLikes") Integer restLikes, @Param("restId") Integer restId);

    Integer updateRestLikesByRestIdBy1(@Param("restId") Integer restId);

    Integer updateRestDislikesByRestIdBy1(@Param("restId") Integer restId);

    Integer insertExceptLikeAndDislike(Restaurant restaurant);

    Integer updateExceptLikeAndDislike(Restaurant restaurant);

    @Select("select count(*) count, dish_name from (select d.* from order_dish od, dish d " +
            "where od.dish_id = d.dish_id and d.rest_id = #{restId}) as n " + "group by dish_id " +
            "order by count desc limit #{rank}")
    List<TopRankDish> selectTopRankOrderedDishesByRestId(@Param("restId") Integer restId, @Param("rank") Integer rank);
}
