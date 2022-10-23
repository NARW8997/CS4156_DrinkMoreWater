package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    public R getAll() {
        return new R(true, userService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, userService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return new R(userService.save(user));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    public R updateById(@RequestBody User user) {
        return new R(userService.updateById(user));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) {
        return new R(userService.removeById(id));
    }
}
