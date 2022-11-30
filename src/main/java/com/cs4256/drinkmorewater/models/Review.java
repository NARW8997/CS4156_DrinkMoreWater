package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
    public Review(Integer reviewId, String content, Integer restId, Integer userId) {
        this.reviewId = reviewId;
        this.content = content;
        this.restId = restId;
        this.userId = userId;
    }
    @TableId("review_id")
    private Integer reviewId;
    private String content;
    private Integer restId;
    private Integer userId;

}