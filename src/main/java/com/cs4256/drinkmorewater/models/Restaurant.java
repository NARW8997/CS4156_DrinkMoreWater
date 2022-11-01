package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @TableId("rest_id")
    private Integer restId;
    private String restLocation;
    private String restName;
    private Integer restLikes;
    private Integer restDislikes;
    private String restNumber;
    private String restSize;
}