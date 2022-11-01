package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Revenue {
    @TableId("revenue_id")
    private Integer revenueId;
    private Integer revenueYear;
    private Integer q1;
    private Integer q2;
    private Integer q3;
    private Integer q4;
    private Integer restId;
}
