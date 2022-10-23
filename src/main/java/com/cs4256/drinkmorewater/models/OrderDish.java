package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderDish {
    @TableId("ordered_dish_id")
    private Integer orderedDishId;
    private Integer orderId;
    private Integer dishId;
}
