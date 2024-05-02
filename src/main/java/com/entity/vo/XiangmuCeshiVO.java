package com.entity.vo;

import com.entity.XiangmuCeshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 测试
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu_ceshi")
public class XiangmuCeshiVO implements Serializable {
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

    @TableField(value = "insert_time")
    private Date insertTime;


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

}
