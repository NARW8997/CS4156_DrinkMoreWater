package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
//    public Restaurant(Integer restId, String restLocation, String restName, Integer restLikes, Integer restDislikes,
//                      String restNumber, String restSize) {
//        this.restId = restId;
//        this.restLocation = restLocation;
//        this.restName = restName;
//        this.restLikes = restLikes;
//        this.restDislikes = restDislikes;
//        this.restNumber = restNumber;
//        this.restSize = restSize;
//    }
    @TableId("rest_id")
    private Integer restId;
    private String restLocation;
    private String restName;
    private Integer restLikes;
    private Integer restDislikes;
    private String restNumber;
    private String restSize;
}