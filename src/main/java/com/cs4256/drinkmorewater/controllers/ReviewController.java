package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.ReviewServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;

    /**
     * return all element
     * @return
     */
    @GetMapping
    public R getAll() {
        return new R(true, reviewService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, reviewService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    public R insert(@RequestBody Review review) {
        return new R(reviewService.save(review));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    public R updateById(@RequestBody Review review) {
        return new R(reviewService.updateById(review));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id) {
        return new R(reviewService.removeById(id));
    }
}
