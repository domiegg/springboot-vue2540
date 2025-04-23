package com.entity.view;

import com.entity.ZongyishiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 中医食疗
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zongyishiliao")
public class ZongyishiliaoView extends ZongyishiliaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 食疗类型的值
		*/
		private String zongyishiliaoValue;



	public ZongyishiliaoView() {

	}

	public ZongyishiliaoView(ZongyishiliaoEntity zongyishiliaoEntity) {
		try {
			BeanUtils.copyProperties(this, zongyishiliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 食疗类型的值
			*/
			public String getZongyishiliaoValue() {
				return zongyishiliaoValue;
			}
			/**
			* 设置： 食疗类型的值
			*/
			public void setZongyishiliaoValue(String zongyishiliaoValue) {
				this.zongyishiliaoValue = zongyishiliaoValue;
			}




















}
