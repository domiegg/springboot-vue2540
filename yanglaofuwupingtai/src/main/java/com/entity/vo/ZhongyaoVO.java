package com.entity.vo;

import com.entity.ZhongyaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 中药信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhongyao")
public class ZhongyaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 中药名称
     */

    @TableField(value = "zhongyao_name")
    private String zhongyaoName;


    /**
     * 中药价格
     */

    @TableField(value = "zhongyao_new_money")
    private Double zhongyaoNewMoney;


    /**
     * 中药库存
     */

    @TableField(value = "zhongyao_kucun_number")
    private Integer zhongyaoKucunNumber;


    /**
     * 中药单位
     */

    @TableField(value = "zhongyao_danwei")
    private Integer zhongyaoDanwei;


    /**
     * 创建时间
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
	 * 设置：中药名称
	 */
    public String getZhongyaoName() {
        return zhongyaoName;
    }


    /**
	 * 获取：中药名称
	 */

    public void setZhongyaoName(String zhongyaoName) {
        this.zhongyaoName = zhongyaoName;
    }
    /**
	 * 设置：中药价格
	 */
    public Double getZhongyaoNewMoney() {
        return zhongyaoNewMoney;
    }


    /**
	 * 获取：中药价格
	 */

    public void setZhongyaoNewMoney(Double zhongyaoNewMoney) {
        this.zhongyaoNewMoney = zhongyaoNewMoney;
    }
    /**
	 * 设置：中药库存
	 */
    public Integer getZhongyaoKucunNumber() {
        return zhongyaoKucunNumber;
    }


    /**
	 * 获取：中药库存
	 */

    public void setZhongyaoKucunNumber(Integer zhongyaoKucunNumber) {
        this.zhongyaoKucunNumber = zhongyaoKucunNumber;
    }
    /**
	 * 设置：中药单位
	 */
    public Integer getZhongyaoDanwei() {
        return zhongyaoDanwei;
    }


    /**
	 * 获取：中药单位
	 */

    public void setZhongyaoDanwei(Integer zhongyaoDanwei) {
        this.zhongyaoDanwei = zhongyaoDanwei;
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

}
