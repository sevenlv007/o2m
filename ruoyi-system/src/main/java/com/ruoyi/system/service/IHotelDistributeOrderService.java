package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HotelDistributeOrder;

/**
 * 酒店分销订单Service接口
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
public interface IHotelDistributeOrderService 
{
    /**
     * 查询酒店分销订单
     * 
     * @param id 酒店分销订单主键
     * @return 酒店分销订单
     */
    public HotelDistributeOrder selectHotelDistributeOrderById(Integer id);

    /**
     * 查询酒店分销订单列表
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 酒店分销订单集合
     */
    public List<HotelDistributeOrder> selectHotelDistributeOrderList(HotelDistributeOrder hotelDistributeOrder);

    /**
     * 新增酒店分销订单
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 结果
     */
    public int insertHotelDistributeOrder(HotelDistributeOrder hotelDistributeOrder);

    /**
     * 修改酒店分销订单
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 结果
     */
    public int updateHotelDistributeOrder(HotelDistributeOrder hotelDistributeOrder);

    /**
     * 批量删除酒店分销订单
     * 
     * @param ids 需要删除的酒店分销订单主键集合
     * @return 结果
     */
    public int deleteHotelDistributeOrderByIds(String ids);

    /**
     * 删除酒店分销订单信息
     * 
     * @param id 酒店分销订单主键
     * @return 结果
     */
    public int deleteHotelDistributeOrderById(Integer id);
}
