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
 * 心里调护
 *
 * @author 
 * @email
 */
@TableName("xinlitiaohu")
public class XinlitiaohuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinlitiaohuEntity() {

	}

	public XinlitiaohuEntity(T t) {
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
    @TableField(value = "xinlitiaohu_name")

    private String xinlitiaohuName;


    /**
     * 心里调护类型
     */
    @TableField(value = "xinlitiaohu_types")

    private Integer xinlitiaohuTypes;


    /**
     * 封面
     */
    @TableField(value = "xinlitiaohu_photo")

    private String xinlitiaohuPhoto;


    /**
     * 视频
     */
    @TableField(value = "xinlitiaohu_video")

    private String xinlitiaohuVideo;


    /**
     * 心里调护详情
     */
    @TableField(value = "xinlitiaohu_content")

    private String xinlitiaohuContent;


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
    public String getXinlitiaohuName() {
        return xinlitiaohuName;
    }
    /**
	 * 获取：标题
	 */

    public void setXinlitiaohuName(String xinlitiaohuName) {
        this.xinlitiaohuName = xinlitiaohuName;
    }
    /**
	 * 设置：心里调护类型
	 */
    public Integer getXinlitiaohuTypes() {
        return xinlitiaohuTypes;
    }
    /**
	 * 获取：心里调护类型
	 */

    public void setXinlitiaohuTypes(Integer xinlitiaohuTypes) {
        this.xinlitiaohuTypes = xinlitiaohuTypes;
    }
    /**
	 * 设置：封面
	 */
    public String getXinlitiaohuPhoto() {
        return xinlitiaohuPhoto;
    }
    /**
	 * 获取：封面
	 */

    public void setXinlitiaohuPhoto(String xinlitiaohuPhoto) {
        this.xinlitiaohuPhoto = xinlitiaohuPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getXinlitiaohuVideo() {
        return xinlitiaohuVideo;
    }
    /**
	 * 获取：视频
	 */

    public void setXinlitiaohuVideo(String xinlitiaohuVideo) {
        this.xinlitiaohuVideo = xinlitiaohuVideo;
    }
    /**
	 * 设置：心里调护详情
	 */
    public String getXinlitiaohuContent() {
        return xinlitiaohuContent;
    }
    /**
	 * 获取：心里调护详情
	 */

    public void setXinlitiaohuContent(String xinlitiaohuContent) {
        this.xinlitiaohuContent = xinlitiaohuContent;
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
        return "Xinlitiaohu{" +
            "id=" + id +
            ", xinlitiaohuName=" + xinlitiaohuName +
            ", xinlitiaohuTypes=" + xinlitiaohuTypes +
            ", xinlitiaohuPhoto=" + xinlitiaohuPhoto +
            ", xinlitiaohuVideo=" + xinlitiaohuVideo +
            ", xinlitiaohuContent=" + xinlitiaohuContent +
            ", createTime=" + createTime +
        "}";
    }
}
