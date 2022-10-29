package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.BookmarkMapper;
import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.services.IBookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl extends ServiceImpl<BookmarkMapper, Bookmark>
        implements IBookmarkService {
    @Autowired
    private BookmarkMapper mapper;

    @Override
    public List<Bookmark> getByRestId(Integer restId) {
        return mapper.selectByRestId(restId);
    }

    @Override
    public List<Bookmark> getByUserId(Integer userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public Integer countByUserId(Integer userId) {
        return mapper.countByUserId(userId);
    }

    @Override
    public Integer countByRestId(Integer restId) {
        return mapper.countByRestId(restId);
    }
}
