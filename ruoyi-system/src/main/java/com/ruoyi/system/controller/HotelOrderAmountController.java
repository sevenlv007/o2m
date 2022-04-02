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
import com.ruoyi.system.domain.HotelOrderAmount;
import com.ruoyi.system.service.IHotelOrderAmountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分销订单金额Controller
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
@Controller
@RequestMapping("/system/amount")
public class HotelOrderAmountController extends BaseController
{
    private String prefix = "system/amount";

    @Autowired
    private IHotelOrderAmountService hotelOrderAmountService;

    @RequiresPermissions("system:amount:view")
    @GetMapping()
    public String amount()
    {
        return prefix + "/amount";
    }

    /**
     * 查询分销订单金额列表
     */
    @RequiresPermissions("system:amount:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HotelOrderAmount hotelOrderAmount)
    {
        startPage();
        List<HotelOrderAmount> list = hotelOrderAmountService.selectHotelOrderAmountList(hotelOrderAmount);
        return getDataTable(list);
    }

    /**
     * 导出分销订单金额列表
     */
    @RequiresPermissions("system:amount:export")
    @Log(title = "分销订单金额", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HotelOrderAmount hotelOrderAmount)
    {
        List<HotelOrderAmount> list = hotelOrderAmountService.selectHotelOrderAmountList(hotelOrderAmount);
        ExcelUtil<HotelOrderAmount> util = new ExcelUtil<HotelOrderAmount>(HotelOrderAmount.class);
        return util.exportExcel(list, "分销订单金额数据");
    }

    /**
     * 新增分销订单金额
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存分销订单金额
     */
    @RequiresPermissions("system:amount:add")
    @Log(title = "分销订单金额", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HotelOrderAmount hotelOrderAmount)
    {
        return toAjax(hotelOrderAmountService.insertHotelOrderAmount(hotelOrderAmount));
    }

    /**
     * 修改分销订单金额
     */
    @RequiresPermissions("system:amount:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        HotelOrderAmount hotelOrderAmount = hotelOrderAmountService.selectHotelOrderAmountById(id);
        mmap.put("hotelOrderAmount", hotelOrderAmount);
        return prefix + "/edit";
    }

    /**
     * 修改保存分销订单金额
     */
    @RequiresPermissions("system:amount:edit")
    @Log(title = "分销订单金额", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HotelOrderAmount hotelOrderAmount)
    {
        return toAjax(hotelOrderAmountService.updateHotelOrderAmount(hotelOrderAmount));
    }

    /**
     * 删除分销订单金额
     */
    @RequiresPermissions("system:amount:remove")
    @Log(title = "分销订单金额", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hotelOrderAmountService.deleteHotelOrderAmountByIds(ids));
    }
}
