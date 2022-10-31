package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    public R getAll() {
        return new R(true, restaurantService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, restaurantService.getById(id));
    }

    @GetMapping("/details")
    public R getAllRestDetails() {
        return new R(true, restaurantService.selectAllRestDetail());
    }

    @GetMapping("/{id}/details")
    public R getRestDetailsById(@PathVariable Integer id) {
        return new R (true, restaurantService.selectRestDetailById(id));
    }

    @GetMapping("/{id}/{likes}/like")
    public R updateRestLikesByRestId(@PathVariable Integer id, @PathVariable Integer likes) {
        return new R (restaurantService.updateRestLikesByRestId(likes, id) > 0);
    }

    @GetMapping("/{id}/{dislikes}/dislike")
    public R updateRestDislikesByRestId(@PathVariable Integer id, @PathVariable Integer dislikes) {
        return new R (restaurantService.updateRestDislikesByRestId(dislikes, id) > 0);
    }

    @GetMapping("/{id}/like")
    public R updateRestLikesByRestIdBy1(@PathVariable Integer id) {
        return new R (restaurantService.updateRestLikesByRestIdBy1(id) > 0);
    }

    @GetMapping("/{id}/dislike")
    public R updateRestDislikesByRestIdBy1(@PathVariable Integer id) {
        return new R (restaurantService.updateRestDislikesByRestIdBy1(id) > 0);
    }

    @GetMapping("/popular")
    public R getPopularRestaurants() {
        return new R(true, restaurantService.getPopularRestaurants());
    }

//    @PutMapping("/{userId}/{restId}/mark/")
//    public R updateMarkByUserIdBy1() {
//
//    }
//
//    @PutMapping("/{userId}/{restId}/unmark")
//    public

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    public R insert(@RequestBody Restaurant restaurant) {
        return new R(restaurantService.save(restaurant));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    public R updateById(@RequestBody Restaurant restaurant) {
        return new R(restaurantService.updateById(restaurant));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) {
        return new R(restaurantService.removeById(id));
    }
}
