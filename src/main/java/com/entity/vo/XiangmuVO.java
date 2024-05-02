package com.entity.vo;

import com.entity.XiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmu")
public class XiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

}
