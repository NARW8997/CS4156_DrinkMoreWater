package com.cs4256.drinkmorewater.controllers;


import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.controllers.utils.UserType;
import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.services.impl.BookmarkServiceImpl;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/{uid}/bookmark")
public class BookMarkController {
    @Autowired
    private BookmarkServiceImpl bookMarkService;

    @Autowired
    private UserServiceImpl userService;

    private UserType userType;

    @ModelAttribute
    private void createUserType(@PathVariable Integer uid) {
        userType = new UserType(uid, userService.getById(uid).getType());
    }

    @GetMapping("/user/{userId}")
    // admin, user(id)
    public R getByUserId(@PathVariable Integer userId) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.getByUserId(userId));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
        userType.getUid().equals(userId)) {
            return new R(true, bookMarkService.getByUserId(userId));
        }
        return new R (false, "You do not have right");
    }

    // TODO: decide which way to take for rest_owner
    @GetMapping("/rest/{restId}")
    // admin, rest(id)
    public R getByRestId(@PathVariable Integer restId) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.getByRestId(restId));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT)) {
            return new R(true, bookMarkService.getByRestId(restId));
        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/countuser/{userId}")
    // admin, user(id)
    public R countByUserId(@PathVariable Integer userId) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.countByUserId(userId));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
                userType.getUid().equals(userId)) {
            return new R(true, bookMarkService.countByUserId(userId));
        }
        return new R (false, "You do not have right");
    }

    @GetMapping("/countrest/{restId}")
    // admin, user, rest
    public R countByRestId(@PathVariable Integer restId) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.countByRestId(restId));
        } else if (userType.getTypeEnum().equals(TypeEnum.RESTAURANT)) {
            return new R(true, bookMarkService.countByRestId(restId));
        }
        return new R (false, "You do not have right");
    }

    /**
     * return all element
     * @return
     */
    @GetMapping
    // admin
    public R getAll() {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.list());
        }
        return new R (false, "You do not have right");
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin
    public R getById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(true, bookMarkService.getById(id));
        }
        return new R (false, "You do not have right");
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, user(id)
    public R insert(@RequestBody Bookmark mark) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(bookMarkService.save(mark));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
                userType.getUid().equals(mark.getUserId())) {
            return new R(bookMarkService.save(mark));
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
    public R updateById(@RequestBody Bookmark mark) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(bookMarkService.updateById(mark));
        }
        return new R (false, "You do not have right");
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, user(id)
    public R deleteById(@PathVariable Integer id) {
        if (userType.getTypeEnum().equals(TypeEnum.ADMIN)) {
            return new R(bookMarkService.removeById(id));
        } else if (userType.getTypeEnum().equals(TypeEnum.CUSTOMER) &&
                userType.getUid().equals(bookMarkService.getById(id).getUserId())) {
            return new R(bookMarkService.removeById(id));
        }
        return new R (false, "You do not have right");
    }

}
