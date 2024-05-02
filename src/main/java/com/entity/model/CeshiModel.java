package com.entity.model;

import com.entity.CeshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 测试人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CeshiModel implements Serializable {
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
     * 测试人员姓名
     */
    private String ceshiName;


    /**
     * 测试人员手机号
     */
    private String ceshiPhone;


    /**
     * 测试人员身份证号
     */
    private String ceshiIdNumber;


    /**
     * 测试人员照片
     */
    private String ceshiPhoto;


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
	 * 获取：测试人员姓名
	 */
    public String getCeshiName() {
        return ceshiName;
    }


    /**
	 * 设置：测试人员姓名
	 */
    public void setCeshiName(String ceshiName) {
        this.ceshiName = ceshiName;
    }
    /**
	 * 获取：测试人员手机号
	 */
    public String getCeshiPhone() {
        return ceshiPhone;
    }


    /**
	 * 设置：测试人员手机号
	 */
    public void setCeshiPhone(String ceshiPhone) {
        this.ceshiPhone = ceshiPhone;
    }
    /**
	 * 获取：测试人员身份证号
	 */
    public String getCeshiIdNumber() {
        return ceshiIdNumber;
    }


    /**
	 * 设置：测试人员身份证号
	 */
    public void setCeshiIdNumber(String ceshiIdNumber) {
        this.ceshiIdNumber = ceshiIdNumber;
    }
    /**
	 * 获取：测试人员照片
	 */
    public String getCeshiPhoto() {
        return ceshiPhoto;
    }


    /**
	 * 设置：测试人员照片
	 */
    public void setCeshiPhoto(String ceshiPhoto) {
        this.ceshiPhoto = ceshiPhoto;
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
