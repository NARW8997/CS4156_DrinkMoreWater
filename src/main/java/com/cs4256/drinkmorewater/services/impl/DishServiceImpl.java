package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.DishMapper;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.services.IDishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
        implements IDishService {

}
