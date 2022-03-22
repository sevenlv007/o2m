package com.ruoyi.system.controller;



import com.ruoyi.system.domain.*;

import com.ruoyi.system.service.IDmCouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengfeng on 2020/9/18.
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    IDmCouponService  couponService;

    @RequestMapping("/fetch")
    public
    @ResponseBody
    CouponResponse fetchCoupon(@RequestBody CouponRequest req) {
        return this.couponService.fetchCoupon(req);
    }


    @RequestMapping("/return")
    public
    @ResponseBody
    ReturnResponse returnCoupon(@RequestBody CouponRequest req) {
        return this.couponService.returnCoupon(req);
    }

    @RequestMapping("/query")
    public
    @ResponseBody
    QueryResponse queryCoupon(@RequestBody CouponRequest req) {
        return this.couponService.queryCoupon(req);
    }

    

}