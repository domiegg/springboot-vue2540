package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 中医诊断
 *
 * @author 
 * @email
 */
@TableName("zhongyizhenduan")
public class ZhongyizhenduanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhongyizhenduanEntity() {

	}

	public ZhongyizhenduanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 老人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 医生
     */
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 症状
     */
    @TableField(value = "zhongyizhenduan_text")

    private String zhongyizhenduanText;


    /**
     * 回复
     */
    @TableField(value = "zhongyizhenduan_huifu_text")

    private String zhongyizhenduanHuifuText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：老人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }
    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：症状
	 */
    public String getZhongyizhenduanText() {
        return zhongyizhenduanText;
    }
    /**
	 * 获取：症状
	 */

    public void setZhongyizhenduanText(String zhongyizhenduanText) {
        this.zhongyizhenduanText = zhongyizhenduanText;
    }
    /**
	 * 设置：回复
	 */
    public String getZhongyizhenduanHuifuText() {
        return zhongyizhenduanHuifuText;
    }
    /**
	 * 获取：回复
	 */

    public void setZhongyizhenduanHuifuText(String zhongyizhenduanHuifuText) {
        this.zhongyizhenduanHuifuText = zhongyizhenduanHuifuText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhongyizhenduan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yishengId=" + yishengId +
            ", zhongyizhenduanText=" + zhongyizhenduanText +
            ", zhongyizhenduanHuifuText=" + zhongyizhenduanHuifuText +
            ", createTime=" + createTime +
        "}";
    }
}
