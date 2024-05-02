package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 需求
 *
 * @author 
 * @email
 */
@TableName("xuqiu")
public class XuqiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuqiuEntity() {

	}

	public XuqiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 产品经理
     */
    @TableField(value = "chanpinjingli_id")

    private Integer chanpinjingliId;


    /**
     * 需求名称
     */
    @TableField(value = "xuqiu_name")

    private String xuqiuName;


    /**
     * 需求类型
     */
    @TableField(value = "xuqiu_types")

    private Integer xuqiuTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 需求详情
     */
    @TableField(value = "xuqiu_content")

    private String xuqiuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：产品经理
	 */
    public Integer getChanpinjingliId() {
        return chanpinjingliId;
    }


    /**
	 * 获取：产品经理
	 */

    public void setChanpinjingliId(Integer chanpinjingliId) {
        this.chanpinjingliId = chanpinjingliId;
    }
    /**
	 * 设置：需求名称
	 */
    public String getXuqiuName() {
        return xuqiuName;
    }


    /**
	 * 获取：需求名称
	 */

    public void setXuqiuName(String xuqiuName) {
        this.xuqiuName = xuqiuName;
    }
    /**
	 * 设置：需求类型
	 */
    public Integer getXuqiuTypes() {
        return xuqiuTypes;
    }


    /**
	 * 获取：需求类型
	 */

    public void setXuqiuTypes(Integer xuqiuTypes) {
        this.xuqiuTypes = xuqiuTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：需求详情
	 */
    public String getXuqiuContent() {
        return xuqiuContent;
    }


    /**
	 * 获取：需求详情
	 */

    public void setXuqiuContent(String xuqiuContent) {
        this.xuqiuContent = xuqiuContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuqiu{" +
            "id=" + id +
            ", chanpinjingliId=" + chanpinjingliId +
            ", xuqiuName=" + xuqiuName +
            ", xuqiuTypes=" + xuqiuTypes +
            ", insertTime=" + insertTime +
            ", xuqiuContent=" + xuqiuContent +
            ", createTime=" + createTime +
        "}";
    }
}
