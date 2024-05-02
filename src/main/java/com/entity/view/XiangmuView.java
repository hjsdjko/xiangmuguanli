package com.entity.view;

import com.entity.XiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiangmu")
public class XiangmuView extends XiangmuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 项目类型的值
		*/
		private String xiangmuValue;
		/**
		* 项目状态的值
		*/
		private String xiangmuZhuangtaiValue;



		//级联表 xiangmuguanliyuan
			/**
			* 项目管理人姓名
			*/
			private String xiangmuguanliyuanName;
			/**
			* 项目管理人手机号
			*/
			private String xiangmuguanliyuanPhone;
			/**
			* 项目管理人身份证号
			*/
			private String xiangmuguanliyuanIdNumber;
			/**
			* 项目管理人照片
			*/
			private String xiangmuguanliyuanPhoto;

		//级联表 xuqiu
			/**
			* 产品经理
			*/
			private Integer chanpinjingliId;
			/**
			* 需求名称
			*/
			private String xuqiuName;
			/**
			* 需求类型
			*/
			private Integer xuqiuTypes;
				/**
				* 需求类型的值
				*/
				private String xuqiuValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 添加时间
			*/
			private Date insertTime;
			/**
			* 需求详情
			*/
			private String xuqiuContent;

	public XiangmuView() {

	}

	public XiangmuView(XiangmuEntity xiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, xiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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































				//级联表的get和set xiangmuguanliyuan
					/**
					* 获取： 项目管理人姓名
					*/
					public String getXiangmuguanliyuanName() {
						return xiangmuguanliyuanName;
					}
					/**
					* 设置： 项目管理人姓名
					*/
					public void setXiangmuguanliyuanName(String xiangmuguanliyuanName) {
						this.xiangmuguanliyuanName = xiangmuguanliyuanName;
					}
					/**
					* 获取： 项目管理人手机号
					*/
					public String getXiangmuguanliyuanPhone() {
						return xiangmuguanliyuanPhone;
					}
					/**
					* 设置： 项目管理人手机号
					*/
					public void setXiangmuguanliyuanPhone(String xiangmuguanliyuanPhone) {
						this.xiangmuguanliyuanPhone = xiangmuguanliyuanPhone;
					}
					/**
					* 获取： 项目管理人身份证号
					*/
					public String getXiangmuguanliyuanIdNumber() {
						return xiangmuguanliyuanIdNumber;
					}
					/**
					* 设置： 项目管理人身份证号
					*/
					public void setXiangmuguanliyuanIdNumber(String xiangmuguanliyuanIdNumber) {
						this.xiangmuguanliyuanIdNumber = xiangmuguanliyuanIdNumber;
					}
					/**
					* 获取： 项目管理人照片
					*/
					public String getXiangmuguanliyuanPhoto() {
						return xiangmuguanliyuanPhoto;
					}
					/**
					* 设置： 项目管理人照片
					*/
					public void setXiangmuguanliyuanPhoto(String xiangmuguanliyuanPhoto) {
						this.xiangmuguanliyuanPhoto = xiangmuguanliyuanPhoto;
					}




				//级联表的get和set xuqiu
					/**
					* 获取： 产品经理
					*/
					public Integer getChanpinjingliId() {
						return chanpinjingliId;
					}
					/**
					* 设置： 产品经理
					*/
					public void setChanpinjingliId(Integer chanpinjingliId) {
						this.chanpinjingliId = chanpinjingliId;
					}
					/**
					* 获取： 需求名称
					*/
					public String getXuqiuName() {
						return xuqiuName;
					}
					/**
					* 设置： 需求名称
					*/
					public void setXuqiuName(String xuqiuName) {
						this.xuqiuName = xuqiuName;
					}
					/**
					* 获取： 需求类型
					*/
					public Integer getXuqiuTypes() {
						return xuqiuTypes;
					}
					/**
					* 设置： 需求类型
					*/
					public void setXuqiuTypes(Integer xuqiuTypes) {
						this.xuqiuTypes = xuqiuTypes;
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
					* 获取： 需求详情
					*/
					public String getXuqiuContent() {
						return xuqiuContent;
					}
					/**
					* 设置： 需求详情
					*/
					public void setXuqiuContent(String xuqiuContent) {
						this.xuqiuContent = xuqiuContent;
					}



}
