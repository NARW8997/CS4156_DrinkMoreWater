package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.Dish;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.DishServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

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
        return new R(dishService.save(dish));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin, rest(id)
    public R updateById(@RequestBody Dish dish) {
        return new R(dishService.updateById(dish));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, rest(id)
    public R deleteById(@PathVariable Integer id) {
        return new R(dishService.removeById(id));
    }
}
