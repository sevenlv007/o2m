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
import com.ruoyi.system.domain.HotelDistributeOrder;
import com.ruoyi.system.service.IHotelDistributeOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店分销订单Controller
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
@Controller
@RequestMapping("/system/order")
public class HotelDistributeOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IHotelDistributeOrderService hotelDistributeOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询酒店分销订单列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HotelDistributeOrder hotelDistributeOrder)
    {
        startPage();
        List<HotelDistributeOrder> list = hotelDistributeOrderService.selectHotelDistributeOrderList(hotelDistributeOrder);
        return getDataTable(list);
    }

    /**
     * 导出酒店分销订单列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "酒店分销订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HotelDistributeOrder hotelDistributeOrder)
    {
        List<HotelDistributeOrder> list = hotelDistributeOrderService.selectHotelDistributeOrderList(hotelDistributeOrder);
        ExcelUtil<HotelDistributeOrder> util = new ExcelUtil<HotelDistributeOrder>(HotelDistributeOrder.class);
        return util.exportExcel(list, "酒店分销订单数据");
    }

    /**
     * 新增酒店分销订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存酒店分销订单
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "酒店分销订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HotelDistributeOrder hotelDistributeOrder)
    {
        return toAjax(hotelDistributeOrderService.insertHotelDistributeOrder(hotelDistributeOrder));
    }

    /**
     * 修改酒店分销订单
     */
    @RequiresPermissions("system:order:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        HotelDistributeOrder hotelDistributeOrder = hotelDistributeOrderService.selectHotelDistributeOrderById(id);
        mmap.put("hotelDistributeOrder", hotelDistributeOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存酒店分销订单
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "酒店分销订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HotelDistributeOrder hotelDistributeOrder)
    {
        return toAjax(hotelDistributeOrderService.updateHotelDistributeOrder(hotelDistributeOrder));
    }

    /**
     * 删除酒店分销订单
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "酒店分销订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hotelDistributeOrderService.deleteHotelDistributeOrderByIds(ids));
    }
}
