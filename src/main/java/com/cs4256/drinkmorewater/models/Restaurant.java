package com.cs4256.drinkmorewater.models;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @Column(name = "rest_id")
    private Integer restId;

    @Column(name = "rest_name")
    private String restName;

    @Column(name = "rest_location")
    private String restLocation;

    @Column(name = "rest_size")
    private String restSize;

    @Column(name = "rest_number")
    private String restNumber;

    @Column(name = "rest_likes")
    private Integer restLikes;

    @Column(name = "rest_dislikes")
    private Integer restDislikes;

    public Integer getRestaurantId() {
        return restId;
    }

    public void setRestaurantId(Integer restId) {
        this.restId = restId;
    }

    public String getRestaurantName() {
        return restName;
    }

    public void setRestaurantName(String restName) {
        this.restName = restName;
    }

    public String getRestaurantLocation() {
        return restLocation;
    }

    public void setRestaurantLocation(String restLocation) {
        this.restLocation = restLocation;
    }

    public String getRestaurantSize() {
        return restSize;
    }

    public void setRestaurantSize(String restSize) {
        this.restSize = restSize;
    }

    public String getRestaurantNumber() {
        return restNumber;
    }

    public void setRestaurantNumber(String restNumber) {
        this.restNumber = restNumber;
    }

    public Integer getRestaurantLikes() {
        return restLikes;
    }

    public void setRestaurantLikes(Integer restLikes) {
        this.restLikes = restLikes;
    }

    public void AddLikes() {restLikes++;}

    public Integer getRestaurantDislikes() {
        return restDislikes;
    }

    public void setRestaurantDislikes(Integer restDislikes) {
        this.restDislikes = restDislikes;
    }

    public void AddDislikes() {restDislikes++;}
}