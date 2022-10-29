package com.cs4256.drinkmorewater.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cs4256.drinkmorewater.models.Bookmark;

import java.util.List;

public interface IBookmarkService extends IService<Bookmark> {
    List<Bookmark> getByRestId(Integer restId);
    List<Bookmark> getByUserId(Integer userId);
    Integer countByUserId(Integer userId);
    Integer countByRestId(Integer restId);
}
