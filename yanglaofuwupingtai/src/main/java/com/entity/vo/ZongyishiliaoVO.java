package com.entity.vo;

import com.entity.ZongyishiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 中医食疗
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zongyishiliao")
public class ZongyishiliaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
