package com.entity.vo;

import com.entity.XiangmuguanliyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 项目管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiangmuguanliyuan")
public class XiangmuguanliyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 项目管理人姓名
     */

    @TableField(value = "xiangmuguanliyuan_name")
    private String xiangmuguanliyuanName;


    /**
     * 项目管理人手机号
     */

    @TableField(value = "xiangmuguanliyuan_phone")
    private String xiangmuguanliyuanPhone;


    /**
     * 项目管理人身份证号
     */

    @TableField(value = "xiangmuguanliyuan_id_number")
    private String xiangmuguanliyuanIdNumber;


    /**
     * 项目管理人照片
     */

    @TableField(value = "xiangmuguanliyuan_photo")
    private String xiangmuguanliyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：项目管理人姓名
	 */
    public String getXiangmuguanliyuanName() {
        return xiangmuguanliyuanName;
    }


    /**
	 * 获取：项目管理人姓名
	 */

    public void setXiangmuguanliyuanName(String xiangmuguanliyuanName) {
        this.xiangmuguanliyuanName = xiangmuguanliyuanName;
    }
    /**
	 * 设置：项目管理人手机号
	 */
    public String getXiangmuguanliyuanPhone() {
        return xiangmuguanliyuanPhone;
    }


    /**
	 * 获取：项目管理人手机号
	 */

    public void setXiangmuguanliyuanPhone(String xiangmuguanliyuanPhone) {
        this.xiangmuguanliyuanPhone = xiangmuguanliyuanPhone;
    }
    /**
	 * 设置：项目管理人身份证号
	 */
    public String getXiangmuguanliyuanIdNumber() {
        return xiangmuguanliyuanIdNumber;
    }


    /**
	 * 获取：项目管理人身份证号
	 */

    public void setXiangmuguanliyuanIdNumber(String xiangmuguanliyuanIdNumber) {
        this.xiangmuguanliyuanIdNumber = xiangmuguanliyuanIdNumber;
    }
    /**
	 * 设置：项目管理人照片
	 */
    public String getXiangmuguanliyuanPhoto() {
        return xiangmuguanliyuanPhoto;
    }


    /**
	 * 获取：项目管理人照片
	 */

    public void setXiangmuguanliyuanPhoto(String xiangmuguanliyuanPhoto) {
        this.xiangmuguanliyuanPhoto = xiangmuguanliyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
