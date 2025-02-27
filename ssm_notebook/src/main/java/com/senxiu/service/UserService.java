package com.senxiu.service;

import com.github.pagehelper.PageInfo;
import com.senxiu.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-12-10 16:34:42
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    User queryById(Integer uId);

    /**
     * 查询
     * @param user 实例对象
     * @return 查询结果
     */
    List<User> queryAllByLimit(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

}
