package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.OrderProfileMapper;
import com.cs4256.drinkmorewater.models.OrderProfile;
import com.cs4256.drinkmorewater.services.IOrderProfileService;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderProfileServiceImpl extends ServiceImpl<OrderProfileMapper, OrderProfile>
implements IOrderProfileService {

}
