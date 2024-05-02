package com.entity.model;

import com.entity.XiangmuCeshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 测试
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiangmuCeshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 测试人员
     */
    private Integer ceshiId;


    /**
     * 项目
     */
    private Integer xiangmuId;


    /**
     * 模块名称
     */
    private String xiangmuCeshiName;


    /**
     * 模块状态
     */
    private Integer xiangmuCeshiTypes;


    /**
     * 测试详情
     */
    private String xiangmuCeshiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：测试人员
	 */
    public Integer getCeshiId() {
        return ceshiId;
    }


    /**
	 * 设置：测试人员
	 */
    public void setCeshiId(Integer ceshiId) {
        this.ceshiId = ceshiId;
    }
    /**
	 * 获取：项目
	 */
    public Integer getXiangmuId() {
        return xiangmuId;
    }


    /**
	 * 设置：项目
	 */
    public void setXiangmuId(Integer xiangmuId) {
        this.xiangmuId = xiangmuId;
    }
    /**
	 * 获取：模块名称
	 */
    public String getXiangmuCeshiName() {
        return xiangmuCeshiName;
    }


    /**
	 * 设置：模块名称
	 */
    public void setXiangmuCeshiName(String xiangmuCeshiName) {
        this.xiangmuCeshiName = xiangmuCeshiName;
    }
    /**
	 * 获取：模块状态
	 */
    public Integer getXiangmuCeshiTypes() {
        return xiangmuCeshiTypes;
    }


    /**
	 * 设置：模块状态
	 */
    public void setXiangmuCeshiTypes(Integer xiangmuCeshiTypes) {
        this.xiangmuCeshiTypes = xiangmuCeshiTypes;
    }
    /**
	 * 获取：测试详情
	 */
    public String getXiangmuCeshiContent() {
        return xiangmuCeshiContent;
    }


    /**
	 * 设置：测试详情
	 */
    public void setXiangmuCeshiContent(String xiangmuCeshiContent) {
        this.xiangmuCeshiContent = xiangmuCeshiContent;
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
