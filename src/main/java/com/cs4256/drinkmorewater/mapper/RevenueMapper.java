package com.cs4256.drinkmorewater.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Revenue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RevenueMapper extends BaseMapper<Revenue> {
    @Select("SELECT * FROM revenue r WHERE r.rest_id = #{restId} AND r.revenue_year = #{year}")
    Revenue selectRevenueByRestIdAndYear(@Param("restId") Integer restId,
                                         @Param("year") Integer year);

    @Select("SELECT * FROM revenue r WHERE r.rest_id = #{restId}")
    List<Revenue> selectRevenueByRestId(@Param("restId") Integer restId);
}
