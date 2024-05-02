package com.entity.vo;

import com.entity.BuggualiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * bug
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bugguali")
public class BuggualiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * bug名称
     */

    @TableField(value = "bugguali_name")
    private String buggualiName;


    /**
     * bug类型
     */

    @TableField(value = "bugguali_types")
    private Integer buggualiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * bug详情
     */

    @TableField(value = "bugguali_content")
    private String buggualiContent;


    /**
     * bug是否处理
     */

    @TableField(value = "bugguali_chuli_types")
    private Integer buggualiChuliTypes;


    /**
     * 回复详情
     */

    @TableField(value = "reply_content")
    private String replyContent;


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
	 * 设置：bug名称
	 */
    public String getBuggualiName() {
        return buggualiName;
    }


    /**
	 * 获取：bug名称
	 */

    public void setBuggualiName(String buggualiName) {
        this.buggualiName = buggualiName;
    }
    /**
	 * 设置：bug类型
	 */
    public Integer getBuggualiTypes() {
        return buggualiTypes;
    }


    /**
	 * 获取：bug类型
	 */

    public void setBuggualiTypes(Integer buggualiTypes) {
        this.buggualiTypes = buggualiTypes;
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
	 * 设置：bug详情
	 */
    public String getBuggualiContent() {
        return buggualiContent;
    }


    /**
	 * 获取：bug详情
	 */

    public void setBuggualiContent(String buggualiContent) {
        this.buggualiContent = buggualiContent;
    }
    /**
	 * 设置：bug是否处理
	 */
    public Integer getBuggualiChuliTypes() {
        return buggualiChuliTypes;
    }


    /**
	 * 获取：bug是否处理
	 */

    public void setBuggualiChuliTypes(Integer buggualiChuliTypes) {
        this.buggualiChuliTypes = buggualiChuliTypes;
    }
    /**
	 * 设置：回复详情
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 获取：回复详情
	 */

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
