package com.senxiu.service;

import com.github.pagehelper.PageInfo;
import com.senxiu.entity.Events;

import java.util.List;

/**
 * (Events)表服务接口
 *
 * @author makejava
 * @since 2024-12-10 16:33:25
 */
public interface EventsService {

    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    Events queryById(Integer eId);

    /**
     * 分页查询
     * @param events 查询条件
     * @return 查询结果
     */
    List<Events> queryAllByLimit(Events events);

    /**
     * 新增数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    Events insert(Events events);

    /**
     * 修改数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    Events update(Events events);

    /**
     * 通过主键删除数据
     *
     * @param eId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer eId);

}
