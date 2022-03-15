package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 云闪付券码查询对象 dm_coupon
 * 
 * @author K7L
 * @date 2022-03-15
 */
public class DmCoupon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传输订单ID */
    @Excel(name = "传输订单ID")
    private String svcTransId;

    /** 云闪付券码种类 */
    @Excel(name = "云闪付券码种类")
    private String couponId;

    /** 状态 */
    @Excel(name = "状态")
    private Long state;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNo;

    /** 礼券商城订单号 */
    @Excel(name = "礼券商城订单号")
    private String giftMallNo;

    /** 订单时间 */
    @Excel(name = "订单时间")
    private String txnTime;

    /** 券码 */
    @Excel(name = "券码")
    private String couponCode;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String effectiveTm;

    /** 截至时间 */
    @Excel(name = "截至时间")
    private String expireTm;

    /** 序列号 */
    private Long id;

    public void setSvcTransId(String svcTransId) 
    {
        this.svcTransId = svcTransId;
    }

    public String getSvcTransId() 
    {
        return svcTransId;
    }
    public void setCouponId(String couponId) 
    {
        this.couponId = couponId;
    }

    public String getCouponId() 
    {
        return couponId;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setGiftMallNo(String giftMallNo) 
    {
        this.giftMallNo = giftMallNo;
    }

    public String getGiftMallNo() 
    {
        return giftMallNo;
    }
    public void setTxnTime(String txnTime) 
    {
        this.txnTime = txnTime;
    }

    public String getTxnTime() 
    {
        return txnTime;
    }
    public void setCouponCode(String couponCode) 
    {
        this.couponCode = couponCode;
    }

    public String getCouponCode() 
    {
        return couponCode;
    }
    public void setEffectiveTm(String effectiveTm) 
    {
        this.effectiveTm = effectiveTm;
    }

    public String getEffectiveTm() 
    {
        return effectiveTm;
    }
    public void setExpireTm(String expireTm) 
    {
        this.expireTm = expireTm;
    }

    public String getExpireTm() 
    {
        return expireTm;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("svcTransId", getSvcTransId())
            .append("couponId", getCouponId())
            .append("state", getState())
            .append("orderNo", getOrderNo())
            .append("giftMallNo", getGiftMallNo())
            .append("txnTime", getTxnTime())
            .append("couponCode", getCouponCode())
            .append("effectiveTm", getEffectiveTm())
            .append("expireTm", getExpireTm())
            .append("id", getId())
            .toString();
    }
}
