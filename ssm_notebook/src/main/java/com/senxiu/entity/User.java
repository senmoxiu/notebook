package com.senxiu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-12-10 16:34:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 账号名
     */
    private String uName;
/**
     * 用户id
     */
    private Integer uId;
/**
     * 姓名
     */
    private String name;
/**
     * 密码
     */
    private String password;
/**
     * 年龄
     */
    private Integer age;
/**
     * 电话号码
     */
    private String phone;
/**
     * 邮箱
     */
    private String email;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }
}

