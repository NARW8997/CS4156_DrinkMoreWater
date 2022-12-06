package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{uid}/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private Integer type;
    private Integer uid;

/* Admin: ALL 0
users : 1
Order_app: uber eats 2
Restaurants (owners): 3
*/
    @ModelAttribute
    private void getUserType(@PathVariable Integer uid) {
        this.uid = uid;
        type = userService.getById(uid).getType().getType();
    }

    /**
     * return all element
     * @return
     */
    @GetMapping
    // admin
    public R getAll() {
        if (type.equals(TypeEnum.ADMIN.getType())) {
            return new R(true, userService.list());
        }
        return new R(false, "You do not have right");
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        // admin, user(id), rest
        if (type.equals(TypeEnum.ADMIN.getType())) {
            return new R(true, userService.getById(id));
        } else if (type.equals(TypeEnum.CUSTOMER.getType()) &&
                uid.equals(id)) {
            return new R(true, userService.getById(id));
        } else if (type.equals(TypeEnum.RESTAURANT.getType()) &&
                uid.equals(id)) {
            return new R(true, userService.getById(id));
        } else {
            return new R(false, "You do not have right");
        }
    }


    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin
    public R insert(@RequestBody User user) {
        if (type.equals(TypeEnum.ADMIN.getType())) {
            return new R(userService.save(user));
        }
        return new R(false);
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin, user(id)
    public R updateById(@RequestBody User user) {
        if (type.equals(TypeEnum.ADMIN.getType())) {
            return new R(userService.updateById(user));

        }
        else if (type.equals(TypeEnum.CUSTOMER.getType()) &&
                uid.equals(user.getUserId())) {
            return new R(userService.updateById(user));
        }
        return new R(false);
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, user(id)
    public R deleteById(@PathVariable Integer id) {
        if (type.equals(TypeEnum.ADMIN.getType())) {
            return new R(userService.removeById(id));

        }
        else if (type.equals(TypeEnum.CUSTOMER.getType()) &&
                uid.equals(id)) {
            return new R(userService.removeById(id));
        }
        return new R(false);
    }
}
