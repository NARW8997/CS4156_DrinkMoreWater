package com.cs4256.drinkmorewater.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.RestaurantDetail;

import java.util.List;

public interface IRestaurantService extends IService<Restaurant>  {
    List<RestaurantDetail> selectAllRestDetail();

    RestaurantDetail selectRestDetailById(Integer restId);
}
