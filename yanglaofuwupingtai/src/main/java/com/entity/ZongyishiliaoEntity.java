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
 * 中医食疗
 *
 * @author 
 * @email
 */
@TableName("zongyishiliao")
public class ZongyishiliaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZongyishiliaoEntity() {

	}

	public ZongyishiliaoEntity(T t) {
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
     * 标题
     */
    @TableField(value = "zongyishiliao_name")

    private String zongyishiliaoName;


    /**
     * 食疗类型
     */
    @TableField(value = "zongyishiliao_types")

    private Integer zongyishiliaoTypes;


    /**
     * 封面
     */
    @TableField(value = "zongyishiliao_photo")

    private String zongyishiliaoPhoto;


    /**
     * 食疗详情
     */
    @TableField(value = "zongyishiliao_content")

    private String zongyishiliaoContent;


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
	 * 设置：标题
	 */
    public String getZongyishiliaoName() {
        return zongyishiliaoName;
    }
    /**
	 * 获取：标题
	 */

    public void setZongyishiliaoName(String zongyishiliaoName) {
        this.zongyishiliaoName = zongyishiliaoName;
    }
    /**
	 * 设置：食疗类型
	 */
    public Integer getZongyishiliaoTypes() {
        return zongyishiliaoTypes;
    }
    /**
	 * 获取：食疗类型
	 */

    public void setZongyishiliaoTypes(Integer zongyishiliaoTypes) {
        this.zongyishiliaoTypes = zongyishiliaoTypes;
    }
    /**
	 * 设置：封面
	 */
    public String getZongyishiliaoPhoto() {
        return zongyishiliaoPhoto;
    }
    /**
	 * 获取：封面
	 */

    public void setZongyishiliaoPhoto(String zongyishiliaoPhoto) {
        this.zongyishiliaoPhoto = zongyishiliaoPhoto;
    }
    /**
	 * 设置：食疗详情
	 */
    public String getZongyishiliaoContent() {
        return zongyishiliaoContent;
    }
    /**
	 * 获取：食疗详情
	 */

    public void setZongyishiliaoContent(String zongyishiliaoContent) {
        this.zongyishiliaoContent = zongyishiliaoContent;
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
        return "Zongyishiliao{" +
            "id=" + id +
            ", zongyishiliaoName=" + zongyishiliaoName +
            ", zongyishiliaoTypes=" + zongyishiliaoTypes +
            ", zongyishiliaoPhoto=" + zongyishiliaoPhoto +
            ", zongyishiliaoContent=" + zongyishiliaoContent +
            ", createTime=" + createTime +
        "}";
    }
}
