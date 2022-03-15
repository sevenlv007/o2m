package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.DmCoupon;
import com.ruoyi.system.service.IDmCouponService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 云闪付券码查询Controller
 * 
 * @author K7L
 * @date 2022-03-15
 */
@Controller
@RequestMapping("/system/coupon")
public class DmCouponController extends BaseController
{
    private String prefix = "system/coupon";

    @Autowired
    private IDmCouponService dmCouponService;

    @RequiresPermissions("system:coupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询云闪付券码查询列表
     */
    @RequiresPermissions("system:coupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmCoupon dmCoupon)
    {
        startPage();
        List<DmCoupon> list = dmCouponService.selectDmCouponList(dmCoupon);
        return getDataTable(list);
    }

    /**
     * 导出云闪付券码查询列表
     */
    @RequiresPermissions("system:coupon:export")
    @Log(title = "云闪付券码查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DmCoupon dmCoupon)
    {
        List<DmCoupon> list = dmCouponService.selectDmCouponList(dmCoupon);
        ExcelUtil<DmCoupon> util = new ExcelUtil<DmCoupon>(DmCoupon.class);
        return util.exportExcel(list, "云闪付券码查询数据");
    }

    /**
     * 新增云闪付券码查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存云闪付券码查询
     */
    @RequiresPermissions("system:coupon:add")
    @Log(title = "云闪付券码查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DmCoupon dmCoupon)
    {
        return toAjax(dmCouponService.insertDmCoupon(dmCoupon));
    }

    /**
     * 修改云闪付券码查询
     */
    @RequiresPermissions("system:coupon:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DmCoupon dmCoupon = dmCouponService.selectDmCouponById(id);
        mmap.put("dmCoupon", dmCoupon);
        return prefix + "/edit";
    }

    /**
     * 修改保存云闪付券码查询
     */
    @RequiresPermissions("system:coupon:edit")
    @Log(title = "云闪付券码查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DmCoupon dmCoupon)
    {
        return toAjax(dmCouponService.updateDmCoupon(dmCoupon));
    }

    /**
     * 删除云闪付券码查询
     */
    @RequiresPermissions("system:coupon:remove")
    @Log(title = "云闪付券码查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dmCouponService.deleteDmCouponByIds(ids));
    }
}
