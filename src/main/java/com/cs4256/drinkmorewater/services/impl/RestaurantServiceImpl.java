package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.mapper.RestaurantMapper;
import com.cs4256.drinkmorewater.services.IRestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl extends ServiceImpl<RestaurantMapper, Restaurant>
        implements IRestaurantService {

}
