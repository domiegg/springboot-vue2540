package com.entity.view;

import com.entity.XinlitiaohuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 心里调护
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinlitiaohu")
public class XinlitiaohuView extends XinlitiaohuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 心里调护类型的值
		*/
		private String xinlitiaohuValue;



	public XinlitiaohuView() {

	}

	public XinlitiaohuView(XinlitiaohuEntity xinlitiaohuEntity) {
		try {
			BeanUtils.copyProperties(this, xinlitiaohuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 心里调护类型的值
			*/
			public String getXinlitiaohuValue() {
				return xinlitiaohuValue;
			}
			/**
			* 设置： 心里调护类型的值
			*/
			public void setXinlitiaohuValue(String xinlitiaohuValue) {
				this.xinlitiaohuValue = xinlitiaohuValue;
			}




















}
