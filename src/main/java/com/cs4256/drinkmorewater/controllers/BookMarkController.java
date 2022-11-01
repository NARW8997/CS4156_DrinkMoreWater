package com.cs4256.drinkmorewater.controllers;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.Bookmark;
import com.cs4256.drinkmorewater.services.impl.BookmarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/bookmark")
public class BookMarkController {
    @Autowired
    private BookmarkServiceImpl bookMarkService;

    @GetMapping("/user/{userId}")
    // admin, user(id)
    public R getByUserId(@PathVariable Integer userId) {
        return new R(true, bookMarkService.getByUserId(userId));
    }

    @GetMapping("/rest/{restId}")
    // admin, rest(id)
    public R getByRestId(@PathVariable Integer restId) {
        return new R(true, bookMarkService.getByRestId(restId));
    }

    @GetMapping("/countuser/{userId}")
    // admin, user(id)
    public R countByUserId(@PathVariable Integer userId) {

        return new R(true, bookMarkService.countByUserId(userId));
    }

    @GetMapping("/countrest/{restId}")
    // admin, user, rest
    public R countByRestId(@PathVariable Integer restId) {
        return new R(true, bookMarkService.countByRestId(restId));
    }

    /**
     * return all element
     * @return
     */
    @GetMapping
    // admin
    public R getAll() {
        return new R(true, bookMarkService.list());
    }

    /**
     * return an element by its id
     * @return
     */
    @GetMapping("/{id}")
    // admin
    public R getById(@PathVariable Integer id) {
        return new R(true, bookMarkService.getById(id));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    // admin, user(id)
    public R insert(@RequestBody Bookmark mark) {
        return new R(bookMarkService.save(mark));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin
    public R updateById(@RequestBody Bookmark mark) {
        return new R(bookMarkService.updateById(mark));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, user(id)
    public R deleteById(@PathVariable Integer id) {
        return new R(bookMarkService.removeById(id));
    }

}
