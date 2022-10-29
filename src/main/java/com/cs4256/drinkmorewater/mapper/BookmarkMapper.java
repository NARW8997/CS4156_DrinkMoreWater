package com.cs4256.drinkmorewater.mapper;
import java.util.List;

import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.models.UserRest;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Bookmark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookmarkMapper extends BaseMapper<Bookmark> {
    @Select("select u.first_name, r.rest_name from bookmark bk, user u, restaurant r where u.user_id = bk.user_id and r.rest_id = bk.rest_id and r.rest_id = #{restId}")
    List<UserRest> selectByRestId(@Param("restId") Integer restId);
    @Select("select u.first_name, r.rest_name from bookmark bk, user u, restaurant r where u.user_id = bk.user_id and r.rest_id = bk.rest_id and u.user_id = #{userId}")
    List<UserRest> selectByUserId(@Param("userId") Integer userId);

    int countByUserId(@Param("userId") Integer userId);

    int countByRestId(@Param("restId") Integer restId);

}
