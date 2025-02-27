package com.senxiu.service;

import com.github.pagehelper.PageInfo;
import com.senxiu.entity.EventCategories;

import java.util.List;

/**
 * (Eventcategories)表服务接口
 *
 * @author makejava
 * @since 2024-12-10 16:30:20
 */
public interface EventCategoriesService {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    EventCategories queryById(Integer cId);

    /**
     * 分页查询
     * @param eventcategories 查询条件

     * @return 查询结果
     */
    List<EventCategories> queryAllByLimit(EventCategories eventcategories);

    /**
     * 新增数据
     *
     * @param eventcategories 实例对象
     * @return 实例对象
     */
    EventCategories insert(EventCategories eventcategories);

    /**
     * 修改数据
     *
     * @param eventcategories 实例对象
     * @return 实例对象
     */
    EventCategories update(EventCategories eventcategories);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cId);

}
