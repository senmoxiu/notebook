package com.senxiu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.senxiu.entity.Events;
import com.senxiu.mapper.EventsDao;
import com.senxiu.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Events)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 16:33:25
 */
@Service("eventsService")
public class EventsServiceImpl implements EventsService {
    @Autowired
    private EventsDao eventsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    @Override
    public Events queryById(Integer eId) {
        return this.eventsDao.queryById(eId);
    }

    /**
     * 分页查询
     *
     * @param events 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Events> queryAllByLimit(Events events) {
        return this.eventsDao.queryAllByLimit(events);
    }

    /**
     * 新增数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    @Override
    public Events insert(Events events) {
        this.eventsDao.insert(events);
        return events;
    }

    /**
     * 修改数据
     *
     * @param events 实例对象
     * @return 实例对象
     */
    @Override
    public Events update(Events events) {
        this.eventsDao.update(events);
        return this.queryById(events.geteId());
    }

    /**
     * 通过主键删除数据
     *
     * @param eId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer eId) {
        return this.eventsDao.deleteById(eId) > 0;
    }
}
