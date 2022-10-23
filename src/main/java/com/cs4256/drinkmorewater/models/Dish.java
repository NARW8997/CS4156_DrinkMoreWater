package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;

/* serve and dish haven't included in service and controller yet */
@Data
public class Dish {
    @TableId("dish_id")
    private Integer dishId;
    private String dishDescription;
    private String flavor;
    private String dishName;
    private String serveSize;
    private Integer restId;
}
