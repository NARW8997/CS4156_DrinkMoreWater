package com.cs4256.drinkmorewater.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs4256.drinkmorewater.mapper.RevenueMapper;
import com.cs4256.drinkmorewater.models.Revenue;
import com.cs4256.drinkmorewater.services.IRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueServiceImpl extends ServiceImpl<RevenueMapper, Revenue>
    implements IRevenueService {

    @Autowired
    RevenueMapper revenueMapper;

    public List<Revenue> getRevenueByRestId(int restId) {
        return revenueMapper.selectRevenueByRestId(restId);
    }

    public Revenue getRevenueByYear(int restId, int year) {
        return revenueMapper.selectRevenueByRestIdAndYear(restId, year);
    }
}
