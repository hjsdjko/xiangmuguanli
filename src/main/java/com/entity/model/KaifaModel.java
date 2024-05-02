package com.entity.model;

import com.entity.KaifaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 开发人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaifaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 开发人员姓名
     */
    private String kaifaName;


    /**
     * 开发人员手机号
     */
    private String kaifaPhone;


    /**
     * 开发人员身份证号
     */
    private String kaifaIdNumber;


    /**
     * 开发人员照片
     */
    private String kaifaPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：开发人员姓名
	 */
    public String getKaifaName() {
        return kaifaName;
    }


    /**
	 * 设置：开发人员姓名
	 */
    public void setKaifaName(String kaifaName) {
        this.kaifaName = kaifaName;
    }
    /**
	 * 获取：开发人员手机号
	 */
    public String getKaifaPhone() {
        return kaifaPhone;
    }


    /**
	 * 设置：开发人员手机号
	 */
    public void setKaifaPhone(String kaifaPhone) {
        this.kaifaPhone = kaifaPhone;
    }
    /**
	 * 获取：开发人员身份证号
	 */
    public String getKaifaIdNumber() {
        return kaifaIdNumber;
    }


    /**
	 * 设置：开发人员身份证号
	 */
    public void setKaifaIdNumber(String kaifaIdNumber) {
        this.kaifaIdNumber = kaifaIdNumber;
    }
    /**
	 * 获取：开发人员照片
	 */
    public String getKaifaPhoto() {
        return kaifaPhoto;
    }


    /**
	 * 设置：开发人员照片
	 */
    public void setKaifaPhoto(String kaifaPhoto) {
        this.kaifaPhoto = kaifaPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
