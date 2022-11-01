package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.OrderDish;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.OrderDishServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDish")
public class OrderDishController {

    @Autowired
    private OrderDishServiceImpl orderDishService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    // admin, uber eats
    public R getAll() {
        return new R(true, orderDishService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, uber eats, rest(id)
    public R getById(@PathVariable Integer id) {
        return new R(true, orderDishService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, uber eats
    public R insert(@RequestBody OrderDish orderDish) {
        return new R(orderDishService.save(orderDish));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin
    public R updateById(@RequestBody OrderDish orderDish) {
        return new R(orderDishService.updateById(orderDish));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin
    public R deleteById(@PathVariable Integer id) {
        return new R(orderDishService.removeById(id));
    }
}
