package com.entity.vo;

import com.entity.KaifaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 开发人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaifa")
public class KaifaVO implements Serializable {
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
     * 开发人员姓名
     */

    @TableField(value = "kaifa_name")
    private String kaifaName;


    /**
     * 开发人员手机号
     */

    @TableField(value = "kaifa_phone")
    private String kaifaPhone;


    /**
     * 开发人员身份证号
     */

    @TableField(value = "kaifa_id_number")
    private String kaifaIdNumber;


    /**
     * 开发人员照片
     */

    @TableField(value = "kaifa_photo")
    private String kaifaPhoto;


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
	 * 设置：开发人员姓名
	 */
    public String getKaifaName() {
        return kaifaName;
    }


    /**
	 * 获取：开发人员姓名
	 */

    public void setKaifaName(String kaifaName) {
        this.kaifaName = kaifaName;
    }
    /**
	 * 设置：开发人员手机号
	 */
    public String getKaifaPhone() {
        return kaifaPhone;
    }


    /**
	 * 获取：开发人员手机号
	 */

    public void setKaifaPhone(String kaifaPhone) {
        this.kaifaPhone = kaifaPhone;
    }
    /**
	 * 设置：开发人员身份证号
	 */
    public String getKaifaIdNumber() {
        return kaifaIdNumber;
    }


    /**
	 * 获取：开发人员身份证号
	 */

    public void setKaifaIdNumber(String kaifaIdNumber) {
        this.kaifaIdNumber = kaifaIdNumber;
    }
    /**
	 * 设置：开发人员照片
	 */
    public String getKaifaPhoto() {
        return kaifaPhoto;
    }


    /**
	 * 获取：开发人员照片
	 */

    public void setKaifaPhoto(String kaifaPhoto) {
        this.kaifaPhoto = kaifaPhoto;
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
