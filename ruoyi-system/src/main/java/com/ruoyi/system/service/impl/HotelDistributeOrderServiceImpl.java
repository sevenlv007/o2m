package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HotelDistributeOrderMapper;
import com.ruoyi.system.domain.HotelDistributeOrder;
import com.ruoyi.system.domain.OrderGenerateNum;
import com.ruoyi.system.service.IHotelDistributeOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 酒店分销订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-01
 */
@Service
public class HotelDistributeOrderServiceImpl implements IHotelDistributeOrderService 
{
    @Autowired
    private HotelDistributeOrderMapper hotelDistributeOrderMapper;

    /**
     * 查询酒店分销订单
     * 
     * @param id 酒店分销订单主键
     * @return 酒店分销订单
     */
    @Override
    public HotelDistributeOrder selectHotelDistributeOrderById(Integer id)
    {
        return hotelDistributeOrderMapper.selectHotelDistributeOrderById(id);
    }

    /**
     * 查询酒店分销订单列表
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 酒店分销订单
     */
    @Override
    public List<HotelDistributeOrder> selectHotelDistributeOrderList(HotelDistributeOrder hotelDistributeOrder)
    {
        return hotelDistributeOrderMapper.selectHotelDistributeOrderList(hotelDistributeOrder);
    }

    /**
     * 新增酒店分销订单
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 结果
     */
    @Override
    public int insertHotelDistributeOrder(HotelDistributeOrder hotelDistributeOrder)
    {
        HotelDistributeOrder order = new HotelDistributeOrder();
        order.setOrderId(OrderGenerateNum.getInstance().GenerateOrder());   //生成订单号
        order.setOrderState(hotelDistributeOrder.getOrderState());  //订单状态
        order.setHotelCode(hotelDistributeOrder.getHotelCode());  
        order.setStoreCode(hotelDistributeOrder.getStoreCode());
        order.setStaffId(hotelDistributeOrder.getStaffId());
        order.setBdId(hotelDistributeOrder.getBdId());

        //获取当前时间
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String date=dateFormat.format(calendar.getTime());
        order.setUpdatedTime(date);

        return hotelDistributeOrderMapper.insertHotelDistributeOrder(order);
    
    }

    /**
     * 修改酒店分销订单
     * 
     * @param hotelDistributeOrder 酒店分销订单
     * @return 结果
     */
    @Override
    public int updateHotelDistributeOrder(HotelDistributeOrder hotelDistributeOrder)
    {
        return hotelDistributeOrderMapper.updateHotelDistributeOrder(hotelDistributeOrder);
    }

    /**
     * 批量删除酒店分销订单
     * 
     * @param ids 需要删除的酒店分销订单主键
     * @return 结果
     */
    @Override
    public int deleteHotelDistributeOrderByIds(String ids)
    {
        return hotelDistributeOrderMapper.deleteHotelDistributeOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除酒店分销订单信息
     * 
     * @param id 酒店分销订单主键
     * @return 结果
     */
    @Override
    public int deleteHotelDistributeOrderById(Integer id)
    {
        return hotelDistributeOrderMapper.deleteHotelDistributeOrderById(id);
    }
}
