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
import com.ruoyi.system.domain.FlightRight;
import com.ruoyi.system.service.IFlightRightService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机票权益Controller
 * 
 * @author K7L
 * @date 2022-03-10
 */
@Controller
@RequestMapping("/system/right")
public class FlightRightController extends BaseController
{
    private String prefix = "system/right";

    @Autowired
    private IFlightRightService flightRightService;

    @RequiresPermissions("system:right:view")
    @GetMapping()
    public String right()
    {
        return prefix + "/right";
    }

    /**
     * 查询机票权益列表
     */
    @RequiresPermissions("system:right:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FlightRight flightRight)
    {
        startPage();
        List<FlightRight> list = flightRightService.selectFlightRightList(flightRight);
        return getDataTable(list);
    }

    /**
     * 导出机票权益列表
     */
    @RequiresPermissions("system:right:export")
    @Log(title = "机票权益", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FlightRight flightRight)
    {
        List<FlightRight> list = flightRightService.selectFlightRightList(flightRight);
        ExcelUtil<FlightRight> util = new ExcelUtil<FlightRight>(FlightRight.class);
        return util.exportExcel(list, "机票权益数据");
    }

    /**
     * 新增机票权益
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存机票权益
     */
    @RequiresPermissions("system:right:add")
    @Log(title = "机票权益", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FlightRight flightRight)
    {
        return toAjax(flightRightService.insertFlightRight(flightRight));
    }

    /**
     * 修改机票权益
     */
    @RequiresPermissions("system:right:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FlightRight flightRight = flightRightService.selectFlightRightById(id);
        mmap.put("flightRight", flightRight);
        return prefix + "/edit";
    }

    /**
     * 修改保存机票权益
     */
    @RequiresPermissions("system:right:edit")
    @Log(title = "机票权益", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FlightRight flightRight)
    {
        return toAjax(flightRightService.updateFlightRight(flightRight));
    }

    /**
     * 删除机票权益
     */
    @RequiresPermissions("system:right:remove")
    @Log(title = "机票权益", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(flightRightService.deleteFlightRightByIds(ids));
    }
}
