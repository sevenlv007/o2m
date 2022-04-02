package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HotelOrderAmount;

/**
 * 分销订单金额Service接口
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
public interface IHotelOrderAmountService 
{
    /**
     * 查询分销订单金额
     * 
     * @param id 分销订单金额主键
     * @return 分销订单金额
     */
    public HotelOrderAmount selectHotelOrderAmountById(Integer id);

    /**
     * 查询分销订单金额列表
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 分销订单金额集合
     */
    public List<HotelOrderAmount> selectHotelOrderAmountList(HotelOrderAmount hotelOrderAmount);

    /**
     * 新增分销订单金额
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 结果
     */
    public int insertHotelOrderAmount(HotelOrderAmount hotelOrderAmount);

    /**
     * 修改分销订单金额
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 结果
     */
    public int updateHotelOrderAmount(HotelOrderAmount hotelOrderAmount);

    /**
     * 批量删除分销订单金额
     * 
     * @param ids 需要删除的分销订单金额主键集合
     * @return 结果
     */
    public int deleteHotelOrderAmountByIds(String ids);

    /**
     * 删除分销订单金额信息
     * 
     * @param id 分销订单金额主键
     * @return 结果
     */
    public int deleteHotelOrderAmountById(Integer id);
}
