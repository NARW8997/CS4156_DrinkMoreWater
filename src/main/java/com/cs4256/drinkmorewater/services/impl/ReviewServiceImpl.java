package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.mapper.ReviewMapper;
import com.cs4256.drinkmorewater.services.IReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review>
        implements IReviewService {

}
