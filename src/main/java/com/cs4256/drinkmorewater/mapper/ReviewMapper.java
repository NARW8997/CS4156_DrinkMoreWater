package com.cs4256.drinkmorewater.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.UserRestReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper extends BaseMapper<Review> {
    @Select("select u.first_name, rt.rest_name, content from review rw, restaurant rt, user u " +
            "where rw.rest_id = rt.rest_id and rw.user_id = u.user_id and rw.user_id = #{userId}")
    List<UserRestReview> selectUserRestReviewByUserId(@Param("userId") Integer userId);

    @Select("select u.first_name, rt.rest_name, content from review rw, restaurant rt, user u " +
            "where rw.rest_id = rt.rest_id and rw.user_id = u.user_id and rw.rest_id = #{restId}")
    List<UserRestReview> selectUserRestReviewByRestId(@Param("restId") Integer restId);
}
