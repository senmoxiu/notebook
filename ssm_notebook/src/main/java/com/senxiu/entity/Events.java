package com.senxiu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * (Events)实体类
 *
 * @author makejava
 * @since 2024-12-10 16:33:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    /**
     * 事件id
     */
    private Integer eId;
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 事件分类id
     */
    private Integer cId;
    /**
     * 标题
     */
    private String title;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 截止日期
     */
    private Date endDate;
    /**
     * 内容
     */
    private String content;
    /**
     * 级别（0：重要，1：紧急，2：一般）
     */
    private Integer level;
    /**
     * 状态（0：未完成，1：已完成，2：作废）
     */
    private Integer status;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}
