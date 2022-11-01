package com.cs4256.drinkmorewater.controllers;

import com.cs4256.drinkmorewater.controllers.utils.R;
import com.cs4256.drinkmorewater.models.Revenue;
import com.cs4256.drinkmorewater.services.impl.RevenueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restowner/revenue")
public class RevenueController {

    @Autowired
    private RevenueServiceImpl revenueService;

    /**
     * return all element
     * @return list of all revenues
     */
    @GetMapping
    public R getAll() {
        return new R(true, revenueService.list());
    }

    /**
     * return an element by its id
     * @return revenue with specific id
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, revenueService.getById(id));
    }

    @GetMapping("/getByRest/{restId}")
    public R getByRestId(@PathVariable Integer restId) {
        return new R(true, revenueService.getRevenueByRestId(restId));
    }

    @GetMapping("/getByRestYear/{restId}/{year}")
    public R getByRestIdAndYear(@PathVariable Integer restId, @PathVariable Integer year) {
        return new R(true, revenueService.getRevenueByYear(restId, year));
    }

    /**
     * add an element to the corresponding table
     * @return
     */
    @PostMapping
    public R insert(@RequestBody Revenue revenue) {
        return new R(revenueService.save(revenue));
    }

    /**
     * update(change) an element by its id
     * this method REQUIRES to set Model's id
     * @return
     */
    @PutMapping
    // admin, rest(id)
    public R updateById(@RequestBody Revenue revenue) {
        return new R(revenueService.updateById(revenue));
    }

    /**
     * Delete an element by its id
     * @return
     */
    @DeleteMapping("/{id}")
    // admin, rest(id)
    public R deleteById(@PathVariable Integer id) {
        return new R(revenueService.removeById(id));
    }
}

