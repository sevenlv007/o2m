package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息表II对象 student
 * 
 * @author K7L
 * @date 2022-03-12
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "姓名")
    private String sname;

    /**  */
    @Excel(name = "性别")
    private String sgender;

    /**  */
    @Excel(name = "城市")
    private String scity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSname(String sname) 
    {
        this.sname = sname;
    }

    public String getSname() 
    {
        return sname;
    }
    public void setSgender(String sgender) 
    {
        this.sgender = sgender;
    }

    public String getSgender() 
    {
        return sgender;
    }
    public void setScity(String scity) 
    {
        this.scity = scity;
    }

    public String getScity() 
    {
        return scity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sname", getSname())
            .append("sgender", getSgender())
            .append("scity", getScity())
            .toString();
    }
}
