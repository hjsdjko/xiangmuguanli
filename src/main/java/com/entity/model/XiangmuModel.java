package com.entity.model;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目管理员
     */
    private Integer xiangmuguanliyuanId;


    /**
     * 需求
     */
    private Integer xuqiuId;


    /**
     * 项目名称
     */
    private String xiangmuName;


    /**
     * 项目类型
     */
    private Integer xiangmuTypes;


    /**
     * 项目详情
     */
    private String xiangmuContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 项目状态
     */
    private Integer xiangmuZhuangtaiTypes;


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
	 * 获取：项目管理员
	 */
    public Integer getXiangmuguanliyuanId() {
        return xiangmuguanliyuanId;
    }


    /**
	 * 设置：项目管理员
	 */
    public void setXiangmuguanliyuanId(Integer xiangmuguanliyuanId) {
        this.xiangmuguanliyuanId = xiangmuguanliyuanId;
    }
    /**
	 * 获取：需求
	 */
    public Integer getXuqiuId() {
        return xuqiuId;
    }


    /**
	 * 设置：需求
	 */
    public void setXuqiuId(Integer xuqiuId) {
        this.xuqiuId = xuqiuId;
    }
    /**
	 * 获取：项目名称
	 */
    public String getXiangmuName() {
        return xiangmuName;
    }


    /**
	 * 设置：项目名称
	 */
    public void setXiangmuName(String xiangmuName) {
        this.xiangmuName = xiangmuName;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getXiangmuTypes() {
        return xiangmuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setXiangmuTypes(Integer xiangmuTypes) {
        this.xiangmuTypes = xiangmuTypes;
    }
    /**
	 * 获取：项目详情
	 */
    public String getXiangmuContent() {
        return xiangmuContent;
    }


    /**
	 * 设置：项目详情
	 */
    public void setXiangmuContent(String xiangmuContent) {
        this.xiangmuContent = xiangmuContent;
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
	 * 获取：项目状态
	 */
    public Integer getXiangmuZhuangtaiTypes() {
        return xiangmuZhuangtaiTypes;
    }


    /**
	 * 设置：项目状态
	 */
    public void setXiangmuZhuangtaiTypes(Integer xiangmuZhuangtaiTypes) {
        this.xiangmuZhuangtaiTypes = xiangmuZhuangtaiTypes;
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
