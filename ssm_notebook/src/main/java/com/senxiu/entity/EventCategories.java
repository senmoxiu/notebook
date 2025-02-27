package com.senxiu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (EventCategories)实体类
 *
 * @author makejava
 * @since 2024-12-10 16:30:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCategories {
/**
     * 分类id
     */
    private Integer cId;
/**
     * 用户id
     */
    private Integer uId;
/**
     * 分类名称
     */
    private String cName;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}

