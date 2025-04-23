package com.entity.view;

import com.entity.ZhongyaoChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 出入库
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhongyao_churu_inout")
public class ZhongyaoChuruInoutView extends ZhongyaoChuruInoutEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 出入库类型的值
		*/
		private String zhongyaoChuruInoutValue;



	public ZhongyaoChuruInoutView() {

	}

	public ZhongyaoChuruInoutView(ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity) {
		try {
			BeanUtils.copyProperties(this, zhongyaoChuruInoutEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
