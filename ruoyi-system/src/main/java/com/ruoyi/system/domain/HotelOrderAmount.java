package com.ruoyi.system.domain;

import java.math.BigDecimal;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销订单金额对象 hotel_order_amount
 * 
 * @author K7L
 * @date 2022年4月2日
 */
public class HotelOrderAmount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 订单标号 */
    private String orderId;

    /** 标签 */
    @Excel(name = "标签")
    private String tag;

    /** 成本 */
    @Excel(name = "成本")
    private String cost;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private String amount;

    /** 员工奖励 */
    @Excel(name = "员工奖励")
    private BigDecimal staffBonus;

    /** 劳务税收 */
    @Excel(name = "劳务税收")
    private BigDecimal salery;

       /** 更新时间 */
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间")
    private String updatedTime;

    // private HotelDistributeOrder hotelDistributeOrder;


    // public HotelDistributeOrder getHotelDistributeOrder() {
    //     return hotelDistributeOrder;
    // }

    // public void setHotelDistributeOrder(HotelDistributeOrder hotelDistributeOrder) {
    //     this.hotelDistributeOrder = hotelDistributeOrder;
    // }

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
    private String oupdatedTime;

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
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setCost(String cost) 
    {
        this.cost = cost;
    }

    public String getCost() 
    {
        return cost;
    }
    public void setAmount(String amount) 
    {
        this.amount = amount;
    }

    public String getAmount() 
    {
        return amount;
    }
    public void setStaffBonus(BigDecimal staffBonus) 
    {
        this.staffBonus = staffBonus;
    }

    public BigDecimal getStaffBonus() 
    {
        return staffBonus;
    }
    public void setSalery(BigDecimal salery) 
    {
        this.salery = salery;
    }

    public BigDecimal getSalery() 
    {
        return salery;
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
            .append("tag", getTag())
            .append("cost", getCost())
            .append("amount", getAmount())
            .append("staffBonus", getStaffBonus())
            .append("salery", getSalery())
            .append("updatedTime", getUpdatedTime())
            .append("orderState",getOrderState())
            .append("hotelCode", getHotelCode())
            .append("storeCode", getStoreCode())
            .append("staffId",getStaffId())
            .append("bdId",getBdId())
            .append("oupdatedTime",getOupdatedTime())
            // .append("hotelDistributeOrder", hotelDistributeOrder.toString())
            .toString();
    }


    /**
     * @return String return the orderState
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * @param orderState the orderState to set
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * @return String return the hotelCode
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * @param hotelCode the hotelCode to set
     */
    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    /**
     * @return String return the storeCode
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * @param storeCode the storeCode to set
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    /**
     * @return String return the staffId
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * @param staffId the staffId to set
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * @return String return the bdId
     */
    public String getBdId() {
        return bdId;
    }

    /**
     * @param bdId the bdId to set
     */
    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    /**
     * @return String return the oupdatedTime
     */
    public String getOupdatedTime() {
        return oupdatedTime;
    }

    /**
     * @param oupdatedTime the oupdatedTime to set
     */
    public void setOupdatedTime(String oupdatedTime) {
        this.oupdatedTime = oupdatedTime;
    }

}
