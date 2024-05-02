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
 * 项目
 *
 * @author 
 * @email
 */
@TableName("xiangmu")
public class XiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiangmuEntity() {

	}

	public XiangmuEntity(T t) {
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
     * 项目管理员
     */
    @TableField(value = "xiangmuguanliyuan_id")

    private Integer xiangmuguanliyuanId;


    /**
     * 需求
     */
    @TableField(value = "xuqiu_id")

    private Integer xuqiuId;


    /**
     * 项目名称
     */
    @TableField(value = "xiangmu_name")

    private String xiangmuName;


    /**
     * 项目类型
     */
    @TableField(value = "xiangmu_types")

    private Integer xiangmuTypes;


    /**
     * 项目详情
     */
    @TableField(value = "xiangmu_content")

    private String xiangmuContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 项目状态
     */
    @TableField(value = "xiangmu_zhuangtai_types")

    private Integer xiangmuZhuangtaiTypes;


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
	 * 设置：项目管理员
	 */
    public Integer getXiangmuguanliyuanId() {
        return xiangmuguanliyuanId;
    }


    /**
	 * 获取：项目管理员
	 */

    public void setXiangmuguanliyuanId(Integer xiangmuguanliyuanId) {
        this.xiangmuguanliyuanId = xiangmuguanliyuanId;
    }
    /**
	 * 设置：需求
	 */
    public Integer getXuqiuId() {
        return xuqiuId;
    }


    /**
	 * 获取：需求
	 */

    public void setXuqiuId(Integer xuqiuId) {
        this.xuqiuId = xuqiuId;
    }
    /**
	 * 设置：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 设置：项目详情
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 获取：项目详情
	 */

    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
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
	 * 设置：项目状态
	 */
    public Integer getXiangmuZhuangtaiTypes() {
        return xiangmuZhuangtaiTypes;
    }


    /**
	 * 获取：项目状态
	 */

    public void setXiangmuZhuangtaiTypes(Integer xiangmuZhuangtaiTypes) {
        this.xiangmuZhuangtaiTypes = xiangmuZhuangtaiTypes;
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
        return "Xiangmu{" +
            "id=" + id +
            ", xiangmuguanliyuanId=" + xiangmuguanliyuanId +
            ", xuqiuId=" + xuqiuId +
            ", xiangmuName=" + xiangmuName +
            ", xiangmuTypes=" + xiangmuTypes +
            ", xiangmuContent=" + xiangmuContent +
            ", insertTime=" + insertTime +
            ", xiangmuZhuangtaiTypes=" + xiangmuZhuangtaiTypes +
            ", createTime=" + createTime +
        "}";
    }
}
