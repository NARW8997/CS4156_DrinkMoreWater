package com.cs4256.drinkmorewater.models;

import lombok.Data;

@Data
public class RestaurantPopular{
    private Integer restId;
    private String restLocation;
    private String restName;
    private Integer restLikes;
    private Integer restDislikes;
    private String restNumber;
    private String restSize;
    private int totalLikes;
    private int reviews;
}
