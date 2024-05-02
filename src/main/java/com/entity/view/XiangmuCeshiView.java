package com.entity.view;

import com.entity.XiangmuCeshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmu_ceshi")
public class XiangmuCeshiView extends XiangmuCeshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 模块状态的值
		*/
		private String xiangmuCeshiValue;



		//级联表 ceshi
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

	public XiangmuCeshiView() {

	}

	public XiangmuCeshiView(XiangmuCeshiEntity xiangmuCeshiEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuCeshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 模块状态的值
			*/
			public String getXiangmuCeshiValue() {
				return xiangmuCeshiValue;
			}
			/**
			* 设置： 模块状态的值
			*/
			public void setXiangmuCeshiValue(String xiangmuCeshiValue) {
				this.xiangmuCeshiValue = xiangmuCeshiValue;
			}







				//级联表的get和set ceshi
					/**
					* 获取： 测试人员姓名
					*/
					public String getCeshiName() {
						return ceshiName;
					}
					/**
					* 设置： 测试人员姓名
					*/
					public void setCeshiName(String ceshiName) {
						this.ceshiName = ceshiName;
					}
					/**
					* 获取： 测试人员手机号
					*/
					public String getCeshiPhone() {
						return ceshiPhone;
					}
					/**
					* 设置： 测试人员手机号
					*/
					public void setCeshiPhone(String ceshiPhone) {
						this.ceshiPhone = ceshiPhone;
					}
					/**
					* 获取： 测试人员身份证号
					*/
					public String getCeshiIdNumber() {
						return ceshiIdNumber;
					}
					/**
					* 设置： 测试人员身份证号
					*/
					public void setCeshiIdNumber(String ceshiIdNumber) {
						this.ceshiIdNumber = ceshiIdNumber;
					}
					/**
					* 获取： 测试人员照片
					*/
					public String getCeshiPhoto() {
						return ceshiPhoto;
					}
					/**
					* 设置： 测试人员照片
					*/
					public void setCeshiPhoto(String ceshiPhoto) {
						this.ceshiPhoto = ceshiPhoto;
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
