package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.UserMapper;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements IUserService {

}
