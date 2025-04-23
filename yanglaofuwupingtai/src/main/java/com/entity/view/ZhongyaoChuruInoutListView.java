package com.entity.view;

import com.entity.ZhongyaoChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhongyao_churu_inout_list")
public class ZhongyaoChuruInoutListView extends ZhongyaoChuruInoutListEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 zhongyao
			/**
			* 中药名称
			*/
			private String zhongyaoName;

		//级联表 zhongyao_churu_inout
			/**
			* 出入库流水号
			*/
			private String zhongyaoChuruInoutUuidNumber;
			/**
			* 出入库名称
			*/
			private String zhongyaoChuruInoutName;
			/**
			* 出入库类型
			*/
			private Integer zhongyaoChuruInoutTypes;
				/**
				* 出入库类型的值
				*/
				private String zhongyaoChuruInoutValue;

	public ZhongyaoChuruInoutListView() {

	}

	public ZhongyaoChuruInoutListView(ZhongyaoChuruInoutListEntity zhongyaoChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, zhongyaoChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}












































				//级联表的get和set zhongyao

					/**
					* 获取： 中药名称
					*/
					public String getZhongyaoName() {
						return zhongyaoName;
					}
					/**
					* 设置： 中药名称
					*/
					public void setZhongyaoName(String zhongyaoName) {
						this.zhongyaoName = zhongyaoName;
					}


				//级联表的get和set zhongyao_churu_inout

					/**
					* 获取： 出入库流水号
					*/
					public String getZhongyaoChuruInoutUuidNumber() {
						return zhongyaoChuruInoutUuidNumber;
					}
					/**
					* 设置： 出入库流水号
					*/
					public void setZhongyaoChuruInoutUuidNumber(String zhongyaoChuruInoutUuidNumber) {
						this.zhongyaoChuruInoutUuidNumber = zhongyaoChuruInoutUuidNumber;
					}

					/**
					* 获取： 出入库名称
					*/
					public String getZhongyaoChuruInoutName() {
						return zhongyaoChuruInoutName;
					}
					/**
					* 设置： 出入库名称
					*/
					public void setZhongyaoChuruInoutName(String zhongyaoChuruInoutName) {
						this.zhongyaoChuruInoutName = zhongyaoChuruInoutName;
					}

					/**
					* 获取： 出入库类型
					*/
					public Integer getZhongyaoChuruInoutTypes() {
						return zhongyaoChuruInoutTypes;
					}
					/**
					* 设置： 出入库类型
					*/
					public void setZhongyaoChuruInoutTypes(Integer zhongyaoChuruInoutTypes) {
						this.zhongyaoChuruInoutTypes = zhongyaoChuruInoutTypes;
					}


						/**
						* 获取： 出入库类型的值
						*/
						public String getZhongyaoChuruInoutValue() {
							return zhongyaoChuruInoutValue;
						}
						/**
						* 设置： 出入库类型的值
						*/
						public void setZhongyaoChuruInoutValue(String zhongyaoChuruInoutValue) {
							this.zhongyaoChuruInoutValue = zhongyaoChuruInoutValue;
						}













}
