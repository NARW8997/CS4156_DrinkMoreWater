package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderDish {
    public OrderDish(Integer orderedDishId, Integer orderId, Integer dishId) {
        this.orderedDishId = orderedDishId;
        this.orderId = orderId;
        this.dishId = dishId;
    }
    @TableId("ordered_dish_id")
    private Integer orderedDishId;
    private Integer orderId;
    private Integer dishId;
}
