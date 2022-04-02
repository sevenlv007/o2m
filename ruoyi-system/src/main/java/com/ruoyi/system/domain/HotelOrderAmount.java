package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分销订单金额对象 hotel_order_amount
 * 
 * @author ruoyi
 * @date 2022-04-01
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

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
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
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
            .toString();
    }
}
