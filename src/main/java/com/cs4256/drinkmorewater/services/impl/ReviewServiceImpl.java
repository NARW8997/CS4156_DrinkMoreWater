package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.models.UserRestReview;
import com.cs4256.drinkmorewater.services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
        implements IReviewService {
    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<UserRestReview> selectUserRestReviewByUserId(Integer userId) {
        return reviewMapper.selectUserRestReviewByUserId(userId);
    }

    @Override
    public List<UserRestReview> selectUserRestReviewByRestId(Integer restId) {
        return reviewMapper.selectUserRestReviewByRestId(restId);
    }
}
