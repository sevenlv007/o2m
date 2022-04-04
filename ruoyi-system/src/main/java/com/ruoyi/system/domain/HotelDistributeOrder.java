package com.ruoyi.system.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店分销订单对象 hotel_distribute_order
 * 
 * @author K7L
 * @date 2022年4月2日
 */
public class HotelDistributeOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 订单标号 */
    private String orderId;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderState;

    /** 酒店code */
    @Excel(name = "酒店code")
    private String hotelCode;

    /** 酒店门店code */
    @Excel(name = "酒店门店code")
    private String storeCode;

    /** 分销员工id */
    @Excel(name = "分销员工id")
    private String staffId;

    /** 负责bdid */
    @Excel(name = "负责bdid")
    private String bdId;

    /** 更新时间 */
   //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间")
    private String updatedTime;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setOrderState(String orderState) 
    {
        this.orderState = orderState;
    }

    public String getOrderState() 
    {
        return orderState;
    }
    public void setHotelCode(String hotelCode) 
    {
        this.hotelCode = hotelCode;
    }

    public String getHotelCode() 
    {
        return hotelCode;
    }
    public void setStoreCode(String storeCode) 
    {
        this.storeCode = storeCode;
    }

    public String getStoreCode() 
    {
        return storeCode;
    }
    public void setStaffId(String staffId) 
    {
        this.staffId = staffId;
    }

    public String getStaffId() 
    {
        return staffId;
    }
    public void setBdId(String bdId) 
    {
        this.bdId = bdId;
    }

    public String getBdId() 
    {
        return bdId;
    }
    public void setUpdatedTime(String updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("orderState", getOrderState())
            .append("hotelCode", getHotelCode())
            .append("storeCode", getStoreCode())
            .append("staffId", getStaffId())
            .append("bdId", getBdId())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
