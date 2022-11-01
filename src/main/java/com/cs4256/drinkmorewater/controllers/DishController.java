package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.controllers.utils.UserType;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.services.impl.DishServiceImpl;
import com.cs4256.drinkmorewater.services.impl.RestaurantServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{uid}/dish")
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RestaurantServiceImpl restaurantService;
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
    // admin, uber eats, rest, user
    public R getAll() {
        return new R(true, dishService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, uber eats, rest, user
    public R getById(@PathVariable Integer id) {
        return new R(true, dishService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, rest(id)
    public R insert(@RequestBody Dish dish) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(dishService.save(dish));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(restaurantService
                .getById(dish.getRestId())
                .getRestOwnerId())) {
            return new R(dishService.save(dish));
        }
        return new R (false, "You do not have right");
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin, rest(id)
    public R updateById(@RequestBody Dish dish) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(dishService.updateById(dish));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
                userType.getUid().equals(restaurantService
                        .getById(dish.getRestId())
                        .getRestOwnerId())) {
            return new R(dishService.updateById(dish));
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
            return new R(dishService.removeById(id));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(restaurantService
                .getById(dishService.getById(id).getRestId())
                .getRestOwnerId())) {
            return new R(dishService.removeById(id));
        }
        return new R (false, "You do not have right");
    }
}
