package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DmCoupon;

/**
 * 云闪付券码查询Mapper接口
 * 
 * @author K7L
 * @date 2022-03-15
 */
public interface DmCouponMapper 
{
    /**
     * 查询云闪付券码查询
     * 
     * @param id 云闪付券码查询主键
     * @return 云闪付券码查询
     */
    public DmCoupon selectDmCouponById(Long id);

    /**
     * 查询云闪付券码查询列表
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 云闪付券码查询集合
     */
    public List<DmCoupon> selectDmCouponList(DmCoupon dmCoupon);

    /**
     * 新增云闪付券码查询
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    public int insertDmCoupon(DmCoupon dmCoupon);

    /**
     * 修改云闪付券码查询-核销
     *  
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    public int updateDmCoupon(DmCoupon dmCoupon);

    /**
     * 删除云闪付券码查询
     * 
     * @param id 云闪付券码查询主键
     * @return 结果
     */
    public int deleteDmCouponById(Long id);

    /**
     * 批量删除云闪付券码查询
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmCouponByIds(String[] ids);
}
