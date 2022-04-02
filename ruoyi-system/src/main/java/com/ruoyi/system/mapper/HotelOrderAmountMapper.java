package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.HotelOrderAmount;

/**
 * 分销订单金额Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
public interface HotelOrderAmountMapper 
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
     * 删除分销订单金额
     * 
     * @param id 分销订单金额主键
     * @return 结果
     */
    public int deleteHotelOrderAmountById(Integer id);

    /**
     * 批量删除分销订单金额
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHotelOrderAmountByIds(String[] ids);
}
