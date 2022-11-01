package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDetail {
    private Integer restId;
    private String restLocation;
    private String restName;
    private Integer restLikes;
    private Integer restDislikes;
    private String restNumber;
    private String restSize;
    private List<String> contents;
    private List<String> dishes;
}
