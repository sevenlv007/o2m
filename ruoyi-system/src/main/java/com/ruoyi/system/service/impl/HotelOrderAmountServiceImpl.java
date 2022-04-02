package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HotelOrderAmountMapper;
import com.ruoyi.system.domain.HotelOrderAmount;
import com.ruoyi.system.service.IHotelOrderAmountService;
import com.ruoyi.common.core.text.Convert;

/**
 * 分销订单金额Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
@Service
public class HotelOrderAmountServiceImpl implements IHotelOrderAmountService 
{
    @Autowired
    private HotelOrderAmountMapper hotelOrderAmountMapper;

    /**
     * 查询分销订单金额
     * 
     * @param id 分销订单金额主键
     * @return 分销订单金额
     */
    @Override
    public HotelOrderAmount selectHotelOrderAmountById(Integer id)
    {
        return hotelOrderAmountMapper.selectHotelOrderAmountById(id);
    }

    /**
     * 查询分销订单金额列表
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 分销订单金额
     */
    @Override
    public List<HotelOrderAmount> selectHotelOrderAmountList(HotelOrderAmount hotelOrderAmount)
    {
        return hotelOrderAmountMapper.selectHotelOrderAmountList(hotelOrderAmount);
    }

    /**
     * 新增分销订单金额
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 结果
     */
    @Override
    public int insertHotelOrderAmount(HotelOrderAmount hotelOrderAmount)
    {
        return hotelOrderAmountMapper.insertHotelOrderAmount(hotelOrderAmount);
    }

    /**
     * 修改分销订单金额
     * 
     * @param hotelOrderAmount 分销订单金额
     * @return 结果
     */
    @Override
    public int updateHotelOrderAmount(HotelOrderAmount hotelOrderAmount)
    {
        return hotelOrderAmountMapper.updateHotelOrderAmount(hotelOrderAmount);
    }

    /**
     * 批量删除分销订单金额
     * 
     * @param ids 需要删除的分销订单金额主键
     * @return 结果
     */
    @Override
    public int deleteHotelOrderAmountByIds(String ids)
    {
        return hotelOrderAmountMapper.deleteHotelOrderAmountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分销订单金额信息
     * 
     * @param id 分销订单金额主键
     * @return 结果
     */
    @Override
    public int deleteHotelOrderAmountById(Integer id)
    {
        return hotelOrderAmountMapper.deleteHotelOrderAmountById(id);
    }
}
