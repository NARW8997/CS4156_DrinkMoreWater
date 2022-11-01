package com.cs4256.drinkmorewater.mapper;
import java.util.Collection;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Restaurant;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RestaurantMapper extends BaseMapper<Restaurant> {
    Integer updateRestDislikesByRestId(@Param("restDislikes") Integer restDislikes, @Param("restId") Integer restId);

    Integer updateRestLikesByRestId(@Param("restLikes") Integer restLikes, @Param("restId") Integer restId);

    Integer updateRestLikesByRestIdBy1(@Param("restId") Integer restId);

    Integer updateRestDislikesByRestIdBy1(@Param("restId") Integer restId);
}
