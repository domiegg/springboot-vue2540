package com.entity.vo;

import com.entity.XinlitiaohuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 心里调护
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinlitiaohu")
public class XinlitiaohuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
