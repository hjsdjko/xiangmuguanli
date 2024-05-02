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
 * 测试
 *
 * @author 
 * @email
 */
@TableName("xiangmu_ceshi")
public class XiangmuCeshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuCeshiEntity() {

	}

	public XiangmuCeshiEntity(T t) {
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
     * 测试人员
     */
    @TableField(value = "ceshi_id")

    private Integer ceshiId;


    /**
     * 项目
     */
    @TableField(value = "xiangmu_id")

    private Integer xiangmuId;


    /**
     * 模块名称
     */
    @TableField(value = "xiangmu_ceshi_name")

    private String xiangmuCeshiName;


    /**
     * 模块状态
     */
    @TableField(value = "xiangmu_ceshi_types")

    private Integer xiangmuCeshiTypes;


    /**
     * 测试详情
     */
    @TableField(value = "xiangmu_ceshi_content")

    private String xiangmuCeshiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：测试人员
	 */
    public Integer getCeshiId() {
        return ceshiId;
    }


    /**
	 * 获取：测试人员
	 */

    public void setCeshiId(Integer ceshiId) {
        this.ceshiId = ceshiId;
    }
    /**
	 * 设置：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 获取：项目
	 */

    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 设置：模块名称
	 */
    public String getXiangmuCeshiName() {
        return xiangmuCeshiName;
    }


    /**
	 * 获取：模块名称
	 */

    public void setXiangmuCeshiName(String xiangmuCeshiName) {
        this.xiangmuCeshiName = xiangmuCeshiName;
    }
    /**
	 * 设置：模块状态
	 */
    public Integer getXiangmuCeshiTypes() {
        return xiangmuCeshiTypes;
    }


    /**
	 * 获取：模块状态
	 */

    public void setXiangmuCeshiTypes(Integer xiangmuCeshiTypes) {
        this.xiangmuCeshiTypes = xiangmuCeshiTypes;
    }
    /**
	 * 设置：测试详情
	 */
    public String getXiangmuCeshiContent() {
        return xiangmuCeshiContent;
    }


    /**
	 * 获取：测试详情
	 */

    public void setXiangmuCeshiContent(String xiangmuCeshiContent) {
        this.xiangmuCeshiContent = xiangmuCeshiContent;
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
        return "XiangmuCeshi{" +
            "id=" + id +
            ", ceshiId=" + ceshiId +
            ", xiangmuId=" + xiangmuId +
            ", xiangmuCeshiName=" + xiangmuCeshiName +
            ", xiangmuCeshiTypes=" + xiangmuCeshiTypes +
            ", xiangmuCeshiContent=" + xiangmuCeshiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
