package com.senxiu.mapper;

import com.senxiu.entity.EventCategories;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EventCategories)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-10 16:30:19
 */

public interface EventCategoriesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    EventCategories queryById(Integer cId);

    /**
     * 查询指定行数据
     *
     * @param eventcategories 查询条件
     * @return 对象列表
     */
    List<EventCategories> queryAllByLimit(EventCategories eventcategories);

    /**
     * 统计总行数
     *
     * @param eventcategories 查询条件
     * @return 总行数
     */
    long count(EventCategories eventcategories);

    /**
     * 新增数据
     *
     * @param eventcategories 实例对象
     * @return 影响行数
     */
    int insert(EventCategories eventcategories);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Eventcategories> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EventCategories> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Eventcategories> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EventCategories> entities);

    /**
     * 修改数据
     *
     * @param eventcategories 实例对象
     * @return 影响行数
     */
    int update(EventCategories eventcategories);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 影响行数
     */
    int deleteById(Integer cId);

}

