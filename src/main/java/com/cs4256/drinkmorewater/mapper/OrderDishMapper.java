package com.cs4256.drinkmorewater.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.models.OrderDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDishMapper extends BaseMapper<OrderDish>  {
}
