package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class OrderProfile {
    public OrderProfile(Integer orderId, Integer userId, Integer restId, Date orderTime, Integer total) {
        this.orderId = orderId;
        this.userId = userId;
        this.restId = restId;
        this.orderTime = orderTime;
        this.total = total;
    }
    @TableId("order_id")
    private Integer orderId;
    private Integer userId;
    private Integer restId;
    private Date orderTime;
    private Integer total;
}
