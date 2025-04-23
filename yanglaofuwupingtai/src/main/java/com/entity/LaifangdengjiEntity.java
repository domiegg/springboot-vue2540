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
 * 来访登记
 *
 * @author 
 * @email
 */
@TableName("laifangdengji")
public class LaifangdengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaifangdengjiEntity() {

	}

	public LaifangdengjiEntity(T t) {
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
     * 来访人名称
     */
    @TableField(value = "laifangdengji_name")

    private String laifangdengjiName;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "laifangdengji_time")

    private Date laifangdengjiTime;


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
	 * 设置：来访人名称
	 */
    public String getLaifangdengjiName() {
        return laifangdengjiName;
    }
    /**
	 * 获取：来访人名称
	 */

    public void setLaifangdengjiName(String laifangdengjiName) {
        this.laifangdengjiName = laifangdengjiName;
    }
    /**
	 * 设置：来访时间
	 */
    public Date getLaifangdengjiTime() {
        return laifangdengjiTime;
    }
    /**
	 * 获取：来访时间
	 */

    public void setLaifangdengjiTime(Date laifangdengjiTime) {
        this.laifangdengjiTime = laifangdengjiTime;
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
        return "Laifangdengji{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", laifangdengjiName=" + laifangdengjiName +
            ", laifangdengjiTime=" + laifangdengjiTime +
            ", createTime=" + createTime +
        "}";
    }
}
