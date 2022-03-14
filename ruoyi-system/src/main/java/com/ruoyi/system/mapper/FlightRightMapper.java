package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FlightRight;

/**
 * 机票权益Mapper接口
 * 
 * @author K7L
 * @date 2022-03-10
 */
public interface FlightRightMapper 
{
    /**
     * 查询机票权益
     * 
     * @param id 机票权益主键
     * @return 机票权益
     */
    public FlightRight selectFlightRightById(Long id);

    /**
     * 查询机票权益列表
     * 
     * @param flightRight 机票权益
     * @return 机票权益集合
     */
    public List<FlightRight> selectFlightRightList(FlightRight flightRight);

    /**
     * 新增机票权益
     * 
     * @param flightRight 机票权益
     * @return 结果
     */
    public int insertFlightRight(FlightRight flightRight);

    /**
     * 修改机票权益
     * 
     * @param flightRight 机票权益
     * @return 结果
     */
    public int updateFlightRight(FlightRight flightRight);

    /**
     * 删除机票权益
     * 
     * @param id 机票权益主键
     * @return 结果
     */
    public int deleteFlightRightById(Long id);

    /**
     * 批量删除机票权益
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlightRightByIds(String[] ids);
}
