package com.cs4256.drinkmorewater.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class RestaurantDetail extends Restaurant {
    protected Integer restId;
    protected String restLocation;
    protected String restName;
    protected Integer restLikes;
    protected Integer restDislikes;
    protected String restNumber;
    protected String restSize;
    protected Integer restOwnerId;
    private List<String> dishes;
    private List<String> contents;
    private String ownerName;


    public RestaurantDetail(Integer restId, String restLocation, String restName,
                            Integer restLikes, Integer restDislikes, String restNumber,
                            String restSize, Integer restOwnerId, String ownerName) {
        super(restId, restLocation, restName, restLikes, restDislikes,
                restNumber, restSize, restOwnerId);
        this.ownerName = ownerName;
    }
}
