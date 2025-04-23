package com.entity.model;

import com.entity.XinlitiaohuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心里调护
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinlitiaohuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String xinlitiaohuName;


    /**
     * 心里调护类型
     */
    private Integer xinlitiaohuTypes;


    /**
     * 封面
     */
    private String xinlitiaohuPhoto;


    /**
     * 视频
     */
    private String xinlitiaohuVideo;


    /**
     * 心里调护详情
     */
    private String xinlitiaohuContent;


    /**
     * 创建时间 show1 show2 photoShow
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
    public String getXinlitiaohuName() {
        return xinlitiaohuName;
    }


    /**
	 * 设置：标题
	 */
    public void setXinlitiaohuName(String xinlitiaohuName) {
        this.xinlitiaohuName = xinlitiaohuName;
    }
    /**
	 * 获取：心里调护类型
	 */
    public Integer getXinlitiaohuTypes() {
        return xinlitiaohuTypes;
    }


    /**
	 * 设置：心里调护类型
	 */
    public void setXinlitiaohuTypes(Integer xinlitiaohuTypes) {
        this.xinlitiaohuTypes = xinlitiaohuTypes;
    }
    /**
	 * 获取：封面
	 */
    public String getXinlitiaohuPhoto() {
        return xinlitiaohuPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setXinlitiaohuPhoto(String xinlitiaohuPhoto) {
        this.xinlitiaohuPhoto = xinlitiaohuPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getXinlitiaohuVideo() {
        return xinlitiaohuVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setXinlitiaohuVideo(String xinlitiaohuVideo) {
        this.xinlitiaohuVideo = xinlitiaohuVideo;
    }
    /**
	 * 获取：心里调护详情
	 */
    public String getXinlitiaohuContent() {
        return xinlitiaohuContent;
    }


    /**
	 * 设置：心里调护详情
	 */
    public void setXinlitiaohuContent(String xinlitiaohuContent) {
        this.xinlitiaohuContent = xinlitiaohuContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
