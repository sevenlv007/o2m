package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FlightRightMapper;
import com.ruoyi.system.domain.FlightRight;
import com.ruoyi.system.service.IFlightRightService;
import com.ruoyi.common.core.text.Convert;

/**
 * 机票权益Service业务层处理
 * 
 * @author K7L
 * @date 2022-03-10
 */
@Service
public class FlightRightServiceImpl implements IFlightRightService 
{
    @Autowired
    private FlightRightMapper flightRightMapper;

    /**
     * 查询机票权益
     * 
     * @param id 机票权益主键
     * @return 机票权益
     */
    @Override
    public FlightRight selectFlightRightById(Long id)
    {
        return flightRightMapper.selectFlightRightById(id);
    }

    /**
     * 查询机票权益列表
     * 
     * @param flightRight 机票权益
     * @return 机票权益
     */
    @Override
    public List<FlightRight> selectFlightRightList(FlightRight flightRight)
    {
        return flightRightMapper.selectFlightRightList(flightRight);
    }

    /**
     * 新增机票权益
     * 
     * @param flightRight 机票权益
     * @return 结果
     */
    @Override
    public int insertFlightRight(FlightRight flightRight)
    {
        return flightRightMapper.insertFlightRight(flightRight);
    }

    /**
     * 修改机票权益
     * 
     * @param flightRight 机票权益
     * @return 结果
     */
    @Override
    public int updateFlightRight(FlightRight flightRight)
    {
        return flightRightMapper.updateFlightRight(flightRight);
    }

    /**
     * 批量删除机票权益
     * 
     * @param ids 需要删除的机票权益主键
     * @return 结果
     */
    @Override
    public int deleteFlightRightByIds(String ids)
    {
        return flightRightMapper.deleteFlightRightByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机票权益信息
     * 
     * @param id 机票权益主键
     * @return 结果
     */
    @Override
    public int deleteFlightRightById(Long id)
    {
        return flightRightMapper.deleteFlightRightById(id);
    }
}
