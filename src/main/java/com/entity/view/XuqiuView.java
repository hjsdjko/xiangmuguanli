package com.entity.view;

import com.entity.XuqiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 需求
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xuqiu")
public class XuqiuView extends XuqiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 需求类型的值
		*/
		private String xuqiuValue;



		//级联表 chanpinjingli
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

	public XuqiuView() {

	}

	public XuqiuView(XuqiuEntity xuqiuEntity) {
		try {
			BeanUtils.copyProperties(this, xuqiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 需求类型的值
			*/
			public String getXuqiuValue() {
				return xuqiuValue;
			}
			/**
			* 设置： 需求类型的值
			*/
			public void setXuqiuValue(String xuqiuValue) {
				this.xuqiuValue = xuqiuValue;
			}








				//级联表的get和set chanpinjingli
					/**
					* 获取： 产品经理姓名
					*/
					public String getChanpinjingliName() {
						return chanpinjingliName;
					}
					/**
					* 设置： 产品经理姓名
					*/
					public void setChanpinjingliName(String chanpinjingliName) {
						this.chanpinjingliName = chanpinjingliName;
					}
					/**
					* 获取： 产品经理手机号
					*/
					public String getChanpinjingliPhone() {
						return chanpinjingliPhone;
					}
					/**
					* 设置： 产品经理手机号
					*/
					public void setChanpinjingliPhone(String chanpinjingliPhone) {
						this.chanpinjingliPhone = chanpinjingliPhone;
					}
					/**
					* 获取： 产品经理身份证号
					*/
					public String getChanpinjingliIdNumber() {
						return chanpinjingliIdNumber;
					}
					/**
					* 设置： 产品经理身份证号
					*/
					public void setChanpinjingliIdNumber(String chanpinjingliIdNumber) {
						this.chanpinjingliIdNumber = chanpinjingliIdNumber;
					}
					/**
					* 获取： 产品经理照片
					*/
					public String getChanpinjingliPhoto() {
						return chanpinjingliPhoto;
					}
					/**
					* 设置： 产品经理照片
					*/
					public void setChanpinjingliPhoto(String chanpinjingliPhoto) {
						this.chanpinjingliPhoto = chanpinjingliPhoto;
					}


















}
