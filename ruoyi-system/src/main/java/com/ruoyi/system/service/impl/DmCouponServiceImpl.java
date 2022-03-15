package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DmCouponMapper;
import com.ruoyi.system.domain.DmCoupon;
import com.ruoyi.system.service.IDmCouponService;
import com.ruoyi.common.core.text.Convert;

/**
 * 云闪付券码查询Service业务层处理
 * 
 * @author K7L
 * @date 2022-03-15
 */
@Service
public class DmCouponServiceImpl implements IDmCouponService 
{
    @Autowired
    private DmCouponMapper dmCouponMapper;

    /**
     * 查询云闪付券码查询
     * 
     * @param id 云闪付券码查询主键
     * @return 云闪付券码查询
     */
    @Override
    public DmCoupon selectDmCouponById(Long id)
    {
        return dmCouponMapper.selectDmCouponById(id);
    }

    /**
     * 查询云闪付券码查询列表
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 云闪付券码查询
     */
    @Override
    public List<DmCoupon> selectDmCouponList(DmCoupon dmCoupon)
    {
        return dmCouponMapper.selectDmCouponList(dmCoupon);
    }

    /**
     * 新增云闪付券码查询
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    @Override
    public int insertDmCoupon(DmCoupon dmCoupon)
    {
        return dmCouponMapper.insertDmCoupon(dmCoupon);
    }

    /**
     * 修改云闪付券码查询
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    @Override
    public int updateDmCoupon(DmCoupon dmCoupon)
    {
        return dmCouponMapper.updateDmCoupon(dmCoupon);
    }

    /**
     * 批量删除云闪付券码查询
     * 
     * @param ids 需要删除的云闪付券码查询主键
     * @return 结果
     */
    @Override
    public int deleteDmCouponByIds(String ids)
    {
        return dmCouponMapper.deleteDmCouponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除云闪付券码查询信息
     * 
     * @param id 云闪付券码查询主键
     * @return 结果
     */
    @Override
    public int deleteDmCouponById(Long id)
    {
        return dmCouponMapper.deleteDmCouponById(id);
    }
}
