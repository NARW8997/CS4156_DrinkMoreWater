package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.controllers.utils.UserType;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.Review;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.ReviewServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{uid}/review")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewService;
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
    // user, admin, rest
    public R getAll() {
        if (userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(false, "You do not have right");
        }
        return new R(true, reviewService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, user, rest
    public R getById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(false, "You do not have right");
        }
        return new R(true, reviewService.getById(id));
    }


    // admin user rest
    // get by restaurant id -- found all
    @GetMapping("/user/{id}")
    public R getUserRestReviewByUserId(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(false, "You do not have right");
        }
        return new R(true, reviewService.selectUserRestReviewByUserId(id));
    }

    // get by user id -- found all
    @GetMapping("/rest/{id}")
    public R getUserRestReviewByRestId(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(false, "You do not have right");
        }
        return new R(true, reviewService.selectUserRestReviewByRestId(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, user(id)
    public R insert(@RequestBody Review review) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(reviewService.save(review));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
        userType.getUid().equals(review.getUserId())) {
            return new R(reviewService.save(review));
        }
        return new R(false, "You do not have right");
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin
    public R updateById(@RequestBody Review review) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(reviewService.updateById(review));
        }
        return new R(false, "You do not have right");
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, user(id)
    public R deleteById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(reviewService.removeById(id));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
        userType.getUid().equals(id)) {
            return new R(reviewService.removeById(id));
        }
        else {
            return new R(false, "You do not have right");
        }
    }
}
