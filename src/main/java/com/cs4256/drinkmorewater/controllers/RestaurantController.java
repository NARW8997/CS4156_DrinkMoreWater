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
    // admin, uber eats, user, rest
    public R getAll() {
        return new R(true, restaurantService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, uber eats, user, rest
    public R getById(@PathVariable Integer id) {
        return new R(true, restaurantService.getById(id));
    }

    @GetMapping("/details")
    // uber eats, user, rest, admin
    public R getAllRestDetails() {
        return new R(true, restaurantService.selectAllRestDetail());
    }

    @GetMapping("/{id}/details")
    // admin, user, uber eats, rest
    public R getRestDetailsById(@PathVariable Integer id) {
        return new R (true, restaurantService.selectRestDetailById(id));
    }

    @GetMapping("/{id}/{likes}/like")
    // admin
    public R updateRestLikesByRestId(@PathVariable Integer id, @PathVariable Integer likes) {
        return new R (restaurantService.updateRestLikesByRestId(likes, id) > 0);
    }

    @GetMapping("/{id}/{dislikes}/dislike")
    // admin
    public R updateRestDislikesByRestId(@PathVariable Integer id, @PathVariable Integer dislikes) {
        return new R (restaurantService.updateRestDislikesByRestId(dislikes, id) > 0);
    }

    @GetMapping("/{id}/like")
    // admin, user
    public R updateRestLikesByRestIdBy1(@PathVariable Integer id) {
        return new R (restaurantService.updateRestLikesByRestIdBy1(id) > 0);
    }

    @GetMapping("/{id}/dislike")
    // admin, user
    public R updateRestDislikesByRestIdBy1(@PathVariable Integer id) {
        return new R (restaurantService.updateRestDislikesByRestIdBy1(id) > 0);
    }

    @GetMapping("/popular")
    // admin, user, uber eats, rest
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
    // admin, rest
    public R insert(@RequestBody Restaurant restaurant) {
        return new R(restaurantService.save(restaurant));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin, rest(id)
    public R updateById(@RequestBody Restaurant restaurant) {
        return new R(restaurantService.updateById(restaurant));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, rest(id)
    public R deleteById(@PathVariable Integer id) {
        return new R(restaurantService.removeById(id));
    }
}
