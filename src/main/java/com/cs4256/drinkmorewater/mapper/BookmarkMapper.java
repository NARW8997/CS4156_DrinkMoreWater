package com.cs4256.drinkmorewater.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Bookmark;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookmarkMapper extends BaseMapper<Bookmark> {
    List<Bookmark> selectByRestId(@Param("restId") Integer restId);

    List<Bookmark> selectByUserId(@Param("userId") Integer userId);

    int countByUserId(@Param("userId") Integer userId);

    int countByRestId(@Param("restId") Integer restId);

}
