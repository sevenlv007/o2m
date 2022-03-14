package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机票权益对象 flight_right
 * 
 * @author K7L
 * @date 2022-03-10
 */
public class FlightRight extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品描述信息 */
    @Excel(name = "产品描述信息")
    private String desc;

    /** 产品状态 */
    @Excel(name = "产品状态")
    private String status;

    /** 最大销售数量 */
    @Excel(name = "最大销售数量")
    private Long maxCount;

    /** 权益次数 */
    @Excel(name = "权益次数")
    private Long codeAmount;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private BigDecimal salePrice;

    /** 权益有效开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "权益有效开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 权益截止兑换时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "权益截止兑换时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 销售开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleStartDate;

    /** 销售结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date saleEndDate;

    /** 库存 */
    @Excel(name = "库存")
    private Long stock;

    /** 产品来源限制（航司） */
    @Excel(name = "产品来源限制", readConverterExp = "航=司")
    private String sourceLimit;

    /** 预定的入口 */
    @Excel(name = "预定的入口")
    private String orderLink;

    /** 宣传图 */
    @Excel(name = "宣传图")
    private String picture;

    /** 出发地列表 */
    @Excel(name = "出发地列表")
    private String departureList;

    /** 目的地列表 */
    @Excel(name = "目的地列表")
    private String arriveList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setMaxCount(Long maxCount) 
    {
        this.maxCount = maxCount;
    }

    public Long getMaxCount() 
    {
        return maxCount;
    }
    public void setCodeAmount(Long codeAmount) 
    {
        this.codeAmount = codeAmount;
    }

    public Long getCodeAmount() 
    {
        return codeAmount;
    }
    public void setSalePrice(BigDecimal salePrice) 
    {
        this.salePrice = salePrice;
    }

    public BigDecimal getSalePrice() 
    {
        return salePrice;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setSaleStartDate(Date saleStartDate) 
    {
        this.saleStartDate = saleStartDate;
    }

    public Date getSaleStartDate() 
    {
        return saleStartDate;
    }
    public void setSaleEndDate(Date saleEndDate) 
    {
        this.saleEndDate = saleEndDate;
    }

    public Date getSaleEndDate() 
    {
        return saleEndDate;
    }
    public void setStock(Long stock) 
    {
        this.stock = stock;
    }

    public Long getStock() 
    {
        return stock;
    }
    public void setSourceLimit(String sourceLimit) 
    {
        this.sourceLimit = sourceLimit;
    }

    public String getSourceLimit() 
    {
        return sourceLimit;
    }
    public void setOrderLink(String orderLink) 
    {
        this.orderLink = orderLink;
    }

    public String getOrderLink() 
    {
        return orderLink;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setDepartureList(String departureList) 
    {
        this.departureList = departureList;
    }

    public String getDepartureList() 
    {
        return departureList;
    }
    public void setArriveList(String arriveList) 
    {
        this.arriveList = arriveList;
    }

    public String getArriveList() 
    {
        return arriveList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("desc", getDesc())
            .append("status", getStatus())
            .append("maxCount", getMaxCount())
            .append("codeAmount", getCodeAmount())
            .append("salePrice", getSalePrice())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("saleStartDate", getSaleStartDate())
            .append("saleEndDate", getSaleEndDate())
            .append("stock", getStock())
            .append("sourceLimit", getSourceLimit())
            .append("orderLink", getOrderLink())
            .append("picture", getPicture())
            .append("departureList", getDepartureList())
            .append("arriveList", getArriveList())
            .toString();
    }
}
