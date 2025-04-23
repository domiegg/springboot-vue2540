package com.entity.model;

import com.entity.ZhongyaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 中药信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhongyaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 中药名称
     */
    private String zhongyaoName;


    /**
     * 中药价格
     */
    private Double zhongyaoNewMoney;


    /**
     * 中药库存
     */
    private Integer zhongyaoKucunNumber;


    /**
     * 中药单位
     */
    private Integer zhongyaoDanwei;


    /**
     * 创建时间
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
	 * 获取：中药名称
	 */
    public String getZhongyaoName() {
        return zhongyaoName;
    }


    /**
	 * 设置：中药名称
	 */
    public void setZhongyaoName(String zhongyaoName) {
        this.zhongyaoName = zhongyaoName;
    }
    /**
	 * 获取：中药价格
	 */
    public Double getZhongyaoNewMoney() {
        return zhongyaoNewMoney;
    }


    /**
	 * 设置：中药价格
	 */
    public void setZhongyaoNewMoney(Double zhongyaoNewMoney) {
        this.zhongyaoNewMoney = zhongyaoNewMoney;
    }
    /**
	 * 获取：中药库存
	 */
    public Integer getZhongyaoKucunNumber() {
        return zhongyaoKucunNumber;
    }


    /**
	 * 设置：中药库存
	 */
    public void setZhongyaoKucunNumber(Integer zhongyaoKucunNumber) {
        this.zhongyaoKucunNumber = zhongyaoKucunNumber;
    }
    /**
	 * 获取：中药单位
	 */
    public Integer getZhongyaoDanwei() {
        return zhongyaoDanwei;
    }


    /**
	 * 设置：中药单位
	 */
    public void setZhongyaoDanwei(Integer zhongyaoDanwei) {
        this.zhongyaoDanwei = zhongyaoDanwei;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
