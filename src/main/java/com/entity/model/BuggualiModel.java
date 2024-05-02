package com.entity.model;

import com.entity.BuggualiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * bug
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BuggualiModel implements Serializable {
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
     * bug名称
     */
    private String buggualiName;


    /**
     * bug类型
     */
    private Integer buggualiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * bug详情
     */
    private String buggualiContent;


    /**
     * bug是否处理
     */
    private Integer buggualiChuliTypes;


    /**
     * 回复详情
     */
    private String replyContent;


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
	 * 获取：bug名称
	 */
    public String getBuggualiName() {
        return buggualiName;
    }


    /**
	 * 设置：bug名称
	 */
    public void setBuggualiName(String buggualiName) {
        this.buggualiName = buggualiName;
    }
    /**
	 * 获取：bug类型
	 */
    public Integer getBuggualiTypes() {
        return buggualiTypes;
    }


    /**
	 * 设置：bug类型
	 */
    public void setBuggualiTypes(Integer buggualiTypes) {
        this.buggualiTypes = buggualiTypes;
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
	 * 获取：bug详情
	 */
    public String getBuggualiContent() {
        return buggualiContent;
    }


    /**
	 * 设置：bug详情
	 */
    public void setBuggualiContent(String buggualiContent) {
        this.buggualiContent = buggualiContent;
    }
    /**
	 * 获取：bug是否处理
	 */
    public Integer getBuggualiChuliTypes() {
        return buggualiChuliTypes;
    }


    /**
	 * 设置：bug是否处理
	 */
    public void setBuggualiChuliTypes(Integer buggualiChuliTypes) {
        this.buggualiChuliTypes = buggualiChuliTypes;
    }
    /**
	 * 获取：回复详情
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 设置：回复详情
	 */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
