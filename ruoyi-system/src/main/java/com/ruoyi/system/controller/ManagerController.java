package com.ruoyi.system.controller;

import com.ruoyi.system.domain.*;

import com.ruoyi.system.service.IDmCouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengfeng on 2020/9/30.
 */
@RestController
@RequestMapping("/manager")
public class ManagerController
{

    @Autowired
    IDmCouponService couponService;

    @RequestMapping("/used")//核销
    public @ResponseBody
    UsedResponse useCoupon(@RequestBody UsedRequest req){
        return this.couponService.useCoupon(req);
    }



    @RequestMapping("/unUsed")//退款
    public @ResponseBody
    UsedResponse unUseCoupon(@RequestBody UnUseRequest req){
        return this.couponService.unUseCoupon(req);
    }

    


}

