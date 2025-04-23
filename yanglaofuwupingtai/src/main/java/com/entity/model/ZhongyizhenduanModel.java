package com.entity.model;

import com.entity.ZhongyizhenduanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 中医诊断
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhongyizhenduanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 症状
     */
    private String zhongyizhenduanText;


    /**
     * 回复
     */
    private String zhongyizhenduanHuifuText;


    /**
     * 创建时间 show3
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
	 * 获取：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：老人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：症状
	 */
    public String getZhongyizhenduanText() {
        return zhongyizhenduanText;
    }


    /**
	 * 设置：症状
	 */
    public void setZhongyizhenduanText(String zhongyizhenduanText) {
        this.zhongyizhenduanText = zhongyizhenduanText;
    }
    /**
	 * 获取：回复
	 */
    public String getZhongyizhenduanHuifuText() {
        return zhongyizhenduanHuifuText;
    }


    /**
	 * 设置：回复
	 */
    public void setZhongyizhenduanHuifuText(String zhongyizhenduanHuifuText) {
        this.zhongyizhenduanHuifuText = zhongyizhenduanHuifuText;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
