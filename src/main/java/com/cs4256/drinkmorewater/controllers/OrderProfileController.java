package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.controllers.utils.UserType;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.OrderProfile;
import com.cs4256.drinkmorewater.services.impl.OrderProfileServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{uid}/orderProfile")
public class OrderProfileController {

    @Autowired
    private OrderProfileServiceImpl orderProfileService;
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
    // admin, uber
    public R getAll() {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN) ||
        userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(true, orderProfileService.list());
        }
        return new R (false, "You do not have right");
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin, uber eats, rest(id)
    public R getById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN) ||
                userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(true, orderProfileService.getById(id));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT) &&
        userType.getUid().equals(id)) {
            return new R(true, orderProfileService.getById(id));
        }
        return new R (false, "You do not have right");
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, uber eats
    public R insert(@RequestBody OrderProfile orderProfile) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN) ||
        userType.getTypeEnum().equals(TypeEnum.ORDERAPP)) {
            return new R(orderProfileService.save(orderProfile));
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
    public R updateById(@RequestBody OrderProfile orderProfile) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(orderProfileService.updateById(orderProfile));
        }
        return new R (false, "You do not have right");
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin
    public R deleteById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(orderProfileService.removeById(id));
        }
        return new R (false, "You do not have right");
    }
}
