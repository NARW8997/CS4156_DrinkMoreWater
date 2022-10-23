package com.cs4256.drinkmorewater.models;

import javax.persistence.*;
import java.util.Date;

/* serve and dish haven't included in service and controller yet */
@Entity
public class Serve {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_serve.restId")
    private Restaurant restaurant;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_serve.dishId")
    private Dish dish;

    @Column(name = "serve_time")
    private Date serveTime;

    @Column(name = "serve_price")
    private String servePrice;


    /* not sure if restaurant and dish can be set like this */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Date getServeTime() {
        return serveTime;
    }

    public void setServeTime(Date serveTime) {
        this.serveTime = serveTime;
    }

    public String getServePrice() {
        return servePrice;
    }

    public void setServePrice(String servePrice) {
        this.servePrice = servePrice;
    }
}