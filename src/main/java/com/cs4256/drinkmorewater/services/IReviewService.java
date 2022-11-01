package com.cs4256.drinkmorewater.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.UserRestReview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IReviewService extends IService<Review> {
    List<UserRestReview> selectUserRestReviewByUserId(@Param("userId") Integer userId);

    List<UserRestReview> selectUserRestReviewByRestId(@Param("restId") Integer restId);
}
