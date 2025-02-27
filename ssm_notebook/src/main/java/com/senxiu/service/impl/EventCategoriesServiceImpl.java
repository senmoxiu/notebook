package com.senxiu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senxiu.entity.EventCategories;
import com.senxiu.mapper.EventCategoriesDao;
import com.senxiu.service.EventCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (Eventcategories)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 16:30:20
 */
@Service("eventCategoriesService")
public class EventCategoriesServiceImpl implements EventCategoriesService {
    @Autowired
    private EventCategoriesDao eventcategoriesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    @Override
    public EventCategories queryById(Integer cId) {
        return this.eventcategoriesDao.queryById(cId);
    }

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @Override
    public List<EventCategories> queryAllByLimit(EventCategories eventcategories) {
        return this.eventcategoriesDao.queryAllByLimit(eventcategories);
    }

    /**
     * 新增数据
     *
     * @param eventcategories 实例对象
     * @return 实例对象
     */
    @Override
    public EventCategories insert(EventCategories eventcategories) {
        this.eventcategoriesDao.insert(eventcategories);
        return eventcategories;
    }

    /**
     * 修改数据
     *
     * @param eventcategories 实例对象
     * @return 实例对象
     */
    @Override
    public EventCategories update(EventCategories eventcategories) {
        this.eventcategoriesDao.update(eventcategories);
        return this.queryById(eventcategories.getcId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cId) {
        return this.eventcategoriesDao.deleteById(cId) > 0;
    }
}
