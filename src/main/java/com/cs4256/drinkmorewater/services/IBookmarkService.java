package com.cs4256.drinkmorewater.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.models.UserRest;

import java.util.List;

public interface IBookmarkService extends IService<Bookmark> {
    List<UserRest> getByRestId(Integer restId);
    List<UserRest> getByUserId(Integer userId);
    Integer countByUserId(Integer userId);
    Integer countByRestId(Integer restId);
}
