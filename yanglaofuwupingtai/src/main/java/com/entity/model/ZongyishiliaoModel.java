package com.entity.model;

import com.entity.ZongyishiliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 中医食疗
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZongyishiliaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String zongyishiliaoName;


    /**
     * 食疗类型
     */
    private Integer zongyishiliaoTypes;


    /**
     * 封面
     */
    private String zongyishiliaoPhoto;


    /**
     * 食疗详情
     */
    private String zongyishiliaoContent;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：标题
	 */
    public String getZongyishiliaoName() {
        return zongyishiliaoName;
    }


    /**
	 * 设置：标题
	 */
    public void setZongyishiliaoName(String zongyishiliaoName) {
        this.zongyishiliaoName = zongyishiliaoName;
    }
    /**
	 * 获取：食疗类型
	 */
    public Integer getZongyishiliaoTypes() {
        return zongyishiliaoTypes;
    }


    /**
	 * 设置：食疗类型
	 */
    public void setZongyishiliaoTypes(Integer zongyishiliaoTypes) {
        this.zongyishiliaoTypes = zongyishiliaoTypes;
    }
    /**
	 * 获取：封面
	 */
    public String getZongyishiliaoPhoto() {
        return zongyishiliaoPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setZongyishiliaoPhoto(String zongyishiliaoPhoto) {
        this.zongyishiliaoPhoto = zongyishiliaoPhoto;
    }
    /**
	 * 获取：食疗详情
	 */
    public String getZongyishiliaoContent() {
        return zongyishiliaoContent;
    }


    /**
	 * 设置：食疗详情
	 */
    public void setZongyishiliaoContent(String zongyishiliaoContent) {
        this.zongyishiliaoContent = zongyishiliaoContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
