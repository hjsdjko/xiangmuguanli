package com.entity.view;

import com.entity.XiangmuKaifaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目开发人员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmu_kaifa")
public class XiangmuKaifaView extends XiangmuKaifaEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 kaifa
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

		//级联表 xiangmu
			/**
			* 项目管理员
			*/
			private Integer xiangmuguanliyuanId;
			/**
			* 需求
			*/
			private Integer xuqiuId;
			/**
			* 项目名称
			*/
			private String xiangmuName;
			/**
			* 项目类型
			*/
			private Integer xiangmuTypes;
				/**
				* 项目类型的值
				*/
				private String xiangmuValue;
			/**
			* 项目详情
			*/
			private String xiangmuContent;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 添加时间
			*/
			private Date insertTime;
			/**
			* 项目状态
			*/
			private Integer xiangmuZhuangtaiTypes;
				/**
				* 项目状态的值
				*/
				private String xiangmuZhuangtaiValue;

	public XiangmuKaifaView() {

	}

	public XiangmuKaifaView(XiangmuKaifaEntity xiangmuKaifaEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuKaifaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}























				//级联表的get和set kaifa
					/**
					* 获取： 开发人员姓名
					*/
					public String getKaifaName() {
						return kaifaName;
					}
					/**
					* 设置： 开发人员姓名
					*/
					public void setKaifaName(String kaifaName) {
						this.kaifaName = kaifaName;
					}
					/**
					* 获取： 开发人员手机号
					*/
					public String getKaifaPhone() {
						return kaifaPhone;
					}
					/**
					* 设置： 开发人员手机号
					*/
					public void setKaifaPhone(String kaifaPhone) {
						this.kaifaPhone = kaifaPhone;
					}
					/**
					* 获取： 开发人员身份证号
					*/
					public String getKaifaIdNumber() {
						return kaifaIdNumber;
					}
					/**
					* 设置： 开发人员身份证号
					*/
					public void setKaifaIdNumber(String kaifaIdNumber) {
						this.kaifaIdNumber = kaifaIdNumber;
					}
					/**
					* 获取： 开发人员照片
					*/
					public String getKaifaPhoto() {
						return kaifaPhoto;
					}
					/**
					* 设置： 开发人员照片
					*/
					public void setKaifaPhoto(String kaifaPhoto) {
						this.kaifaPhoto = kaifaPhoto;
					}


				//级联表的get和set xiangmu
					/**
					* 获取： 项目管理员
					*/
					public Integer getXiangmuguanliyuanId() {
						return xiangmuguanliyuanId;
					}
					/**
					* 设置： 项目管理员
					*/
					public void setXiangmuguanliyuanId(Integer xiangmuguanliyuanId) {
						this.xiangmuguanliyuanId = xiangmuguanliyuanId;
					}
					/**
					* 获取： 需求
					*/
					public Integer getXuqiuId() {
						return xuqiuId;
					}
					/**
					* 设置： 需求
					*/
					public void setXuqiuId(Integer xuqiuId) {
						this.xuqiuId = xuqiuId;
					}
					/**
					* 获取： 项目名称
					*/
					public String getXiangmuName() {
						return xiangmuName;
					}
					/**
					* 设置： 项目名称
					*/
					public void setXiangmuName(String xiangmuName) {
						this.xiangmuName = xiangmuName;
					}
					/**
					* 获取： 项目类型
					*/
					public Integer getXiangmuTypes() {
						return xiangmuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setXiangmuTypes(Integer xiangmuTypes) {
						this.xiangmuTypes = xiangmuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getXiangmuValue() {
							return xiangmuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setXiangmuValue(String xiangmuValue) {
							this.xiangmuValue = xiangmuValue;
						}
					/**
					* 获取： 项目详情
					*/
					public String getXiangmuContent() {
						return xiangmuContent;
					}
					/**
					* 设置： 项目详情
					*/
					public void setXiangmuContent(String xiangmuContent) {
						this.xiangmuContent = xiangmuContent;
					}
					/**
					* 获取： 添加时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 添加时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 项目状态
					*/
					public Integer getXiangmuZhuangtaiTypes() {
						return xiangmuZhuangtaiTypes;
					}
					/**
					* 设置： 项目状态
					*/
					public void setXiangmuZhuangtaiTypes(Integer xiangmuZhuangtaiTypes) {
						this.xiangmuZhuangtaiTypes = xiangmuZhuangtaiTypes;
					}


						/**
						* 获取： 项目状态的值
						*/
						public String getXiangmuZhuangtaiValue() {
							return xiangmuZhuangtaiValue;
						}
						/**
						* 设置： 项目状态的值
						*/
						public void setXiangmuZhuangtaiValue(String xiangmuZhuangtaiValue) {
							this.xiangmuZhuangtaiValue = xiangmuZhuangtaiValue;
						}
















}
