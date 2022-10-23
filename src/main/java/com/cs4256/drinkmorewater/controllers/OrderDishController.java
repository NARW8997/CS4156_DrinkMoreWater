package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDish")
public class OrderDishController {

    @Autowired
    private UserServiceImpl orderDishService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    public R getAll() {
        return new R(true, orderDishService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, orderDishService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return new R(orderDishService.save(user));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    public R updateById(@RequestBody User user) {
        return new R(orderDishService.updateById(user));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) {
        return new R(orderDishService.removeById(id));
    }
}
