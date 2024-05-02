package com.entity.vo;

import com.entity.CeshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 测试人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ceshi")
public class CeshiVO implements Serializable {
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
     * 测试人员姓名
     */

    @TableField(value = "ceshi_name")
    private String ceshiName;


    /**
     * 测试人员手机号
     */

    @TableField(value = "ceshi_phone")
    private String ceshiPhone;


    /**
     * 测试人员身份证号
     */

    @TableField(value = "ceshi_id_number")
    private String ceshiIdNumber;


    /**
     * 测试人员照片
     */

    @TableField(value = "ceshi_photo")
    private String ceshiPhoto;


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
	 * 设置：测试人员姓名
	 */
    public String getCeshiName() {
        return ceshiName;
    }


    /**
	 * 获取：测试人员姓名
	 */

    public void setCeshiName(String ceshiName) {
        this.ceshiName = ceshiName;
    }
    /**
	 * 设置：测试人员手机号
	 */
    public String getCeshiPhone() {
        return ceshiPhone;
    }


    /**
	 * 获取：测试人员手机号
	 */

    public void setCeshiPhone(String ceshiPhone) {
        this.ceshiPhone = ceshiPhone;
    }
    /**
	 * 设置：测试人员身份证号
	 */
    public String getCeshiIdNumber() {
        return ceshiIdNumber;
    }


    /**
	 * 获取：测试人员身份证号
	 */

    public void setCeshiIdNumber(String ceshiIdNumber) {
        this.ceshiIdNumber = ceshiIdNumber;
    }
    /**
	 * 设置：测试人员照片
	 */
    public String getCeshiPhoto() {
        return ceshiPhoto;
    }


    /**
	 * 获取：测试人员照片
	 */

    public void setCeshiPhoto(String ceshiPhoto) {
        this.ceshiPhoto = ceshiPhoto;
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
