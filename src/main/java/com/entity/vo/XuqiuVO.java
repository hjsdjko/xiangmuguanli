package com.entity.vo;

import com.entity.XuqiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 需求
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuqiu")
public class XuqiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "create_time")
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

}
