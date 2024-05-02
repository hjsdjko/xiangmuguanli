package com.entity.model;

import com.entity.ChanpinjingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品经理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinjingliModel implements Serializable {
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
     * 产品经理姓名
     */
    private String chanpinjingliName;


    /**
     * 产品经理手机号
     */
    private String chanpinjingliPhone;


    /**
     * 产品经理身份证号
     */
    private String chanpinjingliIdNumber;


    /**
     * 产品经理照片
     */
    private String chanpinjingliPhoto;


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
	 * 获取：产品经理姓名
	 */
    public String getChanpinjingliName() {
        return chanpinjingliName;
    }


    /**
	 * 设置：产品经理姓名
	 */
    public void setChanpinjingliName(String chanpinjingliName) {
        this.chanpinjingliName = chanpinjingliName;
    }
    /**
	 * 获取：产品经理手机号
	 */
    public String getChanpinjingliPhone() {
        return chanpinjingliPhone;
    }


    /**
	 * 设置：产品经理手机号
	 */
    public void setChanpinjingliPhone(String chanpinjingliPhone) {
        this.chanpinjingliPhone = chanpinjingliPhone;
    }
    /**
	 * 获取：产品经理身份证号
	 */
    public String getChanpinjingliIdNumber() {
        return chanpinjingliIdNumber;
    }


    /**
	 * 设置：产品经理身份证号
	 */
    public void setChanpinjingliIdNumber(String chanpinjingliIdNumber) {
        this.chanpinjingliIdNumber = chanpinjingliIdNumber;
    }
    /**
	 * 获取：产品经理照片
	 */
    public String getChanpinjingliPhoto() {
        return chanpinjingliPhoto;
    }


    /**
	 * 设置：产品经理照片
	 */
    public void setChanpinjingliPhoto(String chanpinjingliPhoto) {
        this.chanpinjingliPhoto = chanpinjingliPhoto;
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
