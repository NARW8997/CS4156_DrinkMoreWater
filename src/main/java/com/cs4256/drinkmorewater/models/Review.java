package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;

@Data
public class Review {
    @TableId("review_id")
    private Integer reviewId;
    private String content;
    private Integer restId;
    private Integer userId;
}