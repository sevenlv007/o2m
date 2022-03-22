package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DmCoupon;
import com.ruoyi.system.domain.*;

/**
 * 云闪付券码查询Service接口
 * 
 * @author K7L
 * @date 2022-03-15
 */
public interface IDmCouponService 
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
     * 修改云闪付券码查询
     * 
     * @param dmCoupon 云闪付券码查询
     * @return 结果
     */
    public int updateDmCoupon(DmCoupon dmCoupon);

    /**
     * 批量删除云闪付券码查询
     * 
     * @param ids 需要删除的云闪付券码查询主键集合
     * @return 结果
     */
    public int deleteDmCouponByIds(String ids);

    /**
     * 删除云闪付券码查询信息
     * 
     * @param id 云闪付券码查询主键
     * @return 结果
     */
    public int deleteDmCouponById(Long id);

    /**
 * Created by fengfeng on 2020/9/18.
 */
    CouponResponse fetchCoupon(CouponRequest req);

    ReturnResponse returnCoupon(CouponRequest req);

    QueryResponse queryCoupon(CouponRequest req);

    UsedResponse useCoupon(UsedRequest req);

    UsedResponse unUseCoupon(UnUseRequest req);

    void notice(NoticeRequest type);

    CouponManagerResponse queryCouponLocal(CouponManagerRequest request);

    LoginResponse login(LoginRequest request);

    CouponManagerResponse addCoupons(CouponManagerRequest request);


}
