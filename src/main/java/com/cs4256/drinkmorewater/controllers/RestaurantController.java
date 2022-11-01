package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.controllers.utils.UserType;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.Restaurant;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{uid}/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantServiceImpl restaurantService;

    @Autowired
    private UserServiceImpl userService;

    private UserType userType;

    @ModelAttribute
    private void createUserType(@PathVariable Integer uid) {
        userType = new UserType(uid, userService.getById(uid).getType());
    }

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

    @GetMapping("/{restId}/{rank}/topNSeller")
    // admin rest(id)
    public R getTopRankOrderedDishesByRestId(@PathVariable Integer restId, @PathVariable Integer rank) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, restaurantService.getTopRankOrderedDishesByRestId(restId, rank));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(restaurantService.getById(restId).getRestOwnerId())) {
            return new R(true, restaurantService.getTopRankOrderedDishesByRestId(restId, rank));
        }
        else {
            return new R (false, "You do not have right");
        }
    }

    @GetMapping("/{id}/{likes}/like")
    // admin
    public R updateRestLikesByRestId(@PathVariable Integer id, @PathVariable Integer likes) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R (restaurantService.updateRestLikesByRestId(likes, id) > 0);
        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/{id}/{dislikes}/dislike")
    // admin
    public R updateRestDislikesByRestId(@PathVariable Integer id, @PathVariable Integer dislikes) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R (restaurantService.updateRestDislikesByRestId(dislikes, id) > 0);

        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/{id}/like")
    // admin, user
    public R updateRestLikesByRestIdBy1(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN) ||
        userType.getTypeEnum().equals(TypeEnum.CUSTOMER)) {
            return new R (restaurantService.updateRestLikesByRestIdBy1(id) > 0);

        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/{id}/dislike")
    // admin, user
    public R updateRestDislikesByRestIdBy1(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN) ||
                userType.getTypeEnum().equals(TypeEnum.CUSTOMER)) {
            return new R(restaurantService.updateRestDislikesByRestIdBy1(id) > 0);
        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/popular")
    // admin, user, uber eats, rest
    public R getPopularRestaurants() {
        return new R(true, restaurantService.getPopularRestaurants());
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin
    // including dislike & like number
    public R insert(@RequestBody Restaurant restaurant) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(restaurantService.save(restaurant));
        }
        return new R (false, "You do not have right");
    }

    // TODO: conflict with get rest details rest(id)
    @PostMapping("/restOwner")
    // not including dislike & like number
    public R insertByRestOwner(@RequestBody Restaurant restaurant) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(restaurantService.insertExceptLikeAndDislike(restaurant) > 0);
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT)) {
            return new R(restaurantService.insertExceptLikeAndDislike(restaurant) > 0);
        }
        return new R (false, "You do not have right");
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin
    // it can change everything, including dislike & like
    public R updateById(@RequestBody Restaurant restaurant) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(restaurantService.updateById(restaurant));
        }
        return new R (false, "You do not have right");
    }

    @PutMapping("/restOwner")
    // admin rest(id)
    // it can change everything, including dislike & like
    public R updateByRestOwner(@RequestBody Restaurant restaurant) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(restaurantService.updateExceptLikeAndDislike(restaurant) > 0);
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(restaurant.getRestOwnerId())) {
            return new R(restaurantService.updateExceptLikeAndDislike(restaurant) > 0);
        }
        return new R (false, "You do not have right");
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, rest(id)
    public R deleteById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(restaurantService.removeById(id));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(restaurantService.getById(id).getRestOwnerId())) {
            return new R(restaurantService.removeById(id));
        }
        return new R (false, "You do not have right");
    }
}
