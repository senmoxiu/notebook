package com.senxiu.service.impl;

import com.senxiu.entity.User;
import com.senxiu.mapper.UserDao;
import com.senxiu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 16:34:42
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer uId) {
        return this.userDao.queryById(uId);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件

     * @return 查询结果
     */
    @Override
    public List<User> queryAllByLimit(User user) {
        return this.userDao.queryAllByLimit(user);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {

        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.userDao.deleteById(uId) > 0;
    }
}
