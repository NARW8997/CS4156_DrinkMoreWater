package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.OrderProfile;
import com.cs4256.drinkmorewater.services.impl.OrderProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderProfile")
public class OrderProfileController {

    @Autowired
    private OrderProfileServiceImpl orderProfileService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    // admin, uber eats
    public R getAll() {
        return new R(true, orderProfileService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, uber eats, rest(id)
    public R getById(@PathVariable Integer id) {
        return new R(true, orderProfileService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, uber eats
    public R insert(@RequestBody OrderProfile orderProfile) {
        return new R(orderProfileService.save(orderProfile));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin
    public R updateById(@RequestBody OrderProfile orderProfile) {
        return new R(orderProfileService.updateById(orderProfile));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin
    public R deleteById(@PathVariable Integer id) {
        return new R(orderProfileService.removeById(id));
    }
}
