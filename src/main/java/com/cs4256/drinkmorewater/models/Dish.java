package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dish {
    public Dish(Integer dishId, String dishDescription, String flavor, String dishName, String serveSize, Integer restId) {
        this.dishId = dishId;
        this.dishDescription = dishDescription;
        this.flavor = flavor;
        this.dishName = dishName;
        this.serveSize = serveSize;
        this.restId = restId;
    }
    @TableId("dish_id")
    private Integer dishId;
    private String dishDescription;
    private String flavor;
    private String dishName;
    private String serveSize;
    private Integer restId;
}

