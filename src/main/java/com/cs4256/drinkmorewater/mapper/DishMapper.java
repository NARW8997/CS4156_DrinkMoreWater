package com.cs4256.drinkmorewater.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish>  {
}
