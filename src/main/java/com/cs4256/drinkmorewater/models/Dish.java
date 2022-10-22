package com.cs4256.drinkmorewater.models;

import javax.persistence.*;

@Entity
public class Dish {
    @Id
    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "flavor")
    private String dishFlavor;

    @Column(name = "dish_description")
    private String dishDescription;

    @Column(name = "serve_size")
    private String serveSize;

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishFlavor() {
        return dishFlavor;
    }

    public void setDishFlavor(String dishFlavor) {
        this.dishFlavor = dishFlavor;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }

    public String getServeSize() {
        return serveSize;
    }

    public void setServeSize(String serveSize) {
        this.serveSize = serveSize;
    }
}
