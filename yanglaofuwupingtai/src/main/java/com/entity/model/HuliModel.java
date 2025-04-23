package com.entity.model;

import com.entity.HuliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 护理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 护理姓名
     */
    private String huliName;


    /**
     * 头像
     */
    private String huliPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String huliPhone;


    /**
     * 邮箱
     */
    private String huliEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：护理姓名
	 */
    public String getHuliName() {
        return huliName;
    }


    /**
	 * 设置：护理姓名
	 */
    public void setHuliName(String huliName) {
        this.huliName = huliName;
    }
    /**
	 * 获取：头像
	 */
    public String getHuliPhoto() {
        return huliPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setHuliPhoto(String huliPhoto) {
        this.huliPhoto = huliPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getHuliPhone() {
        return huliPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setHuliPhone(String huliPhone) {
        this.huliPhone = huliPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getHuliEmail() {
        return huliEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setHuliEmail(String huliEmail) {
        this.huliEmail = huliEmail;
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
