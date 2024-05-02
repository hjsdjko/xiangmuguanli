package com.entity.model;

import com.entity.XuqiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 需求
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuqiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 产品经理
     */
    private Integer chanpinjingliId;


    /**
     * 需求名称
     */
    private String xuqiuName;


    /**
     * 需求类型
     */
    private Integer xuqiuTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 需求详情
     */
    private String xuqiuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：产品经理
	 */
    public Integer getChanpinjingliId() {
        return chanpinjingliId;
    }


    /**
	 * 设置：产品经理
	 */
    public void setChanpinjingliId(Integer chanpinjingliId) {
        this.chanpinjingliId = chanpinjingliId;
    }
    /**
	 * 获取：需求名称
	 */
    public String getXuqiuName() {
        return xuqiuName;
    }


    /**
	 * 设置：需求名称
	 */
    public void setXuqiuName(String xuqiuName) {
        this.xuqiuName = xuqiuName;
    }
    /**
	 * 获取：需求类型
	 */
    public Integer getXuqiuTypes() {
        return xuqiuTypes;
    }


    /**
	 * 设置：需求类型
	 */
    public void setXuqiuTypes(Integer xuqiuTypes) {
        this.xuqiuTypes = xuqiuTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：需求详情
	 */
    public String getXuqiuContent() {
        return xuqiuContent;
    }


    /**
	 * 设置：需求详情
	 */
    public void setXuqiuContent(String xuqiuContent) {
        this.xuqiuContent = xuqiuContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
