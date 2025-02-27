package com.senxiu.controller;

import com.github.pagehelper.PageInfo;
import com.senxiu.entity.EventCategories;
import com.senxiu.service.EventCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (Eventcategories)表控制层
 *
 * @author makejava
 * @since 2024-12-10 16:30:18
 */
@RestController
@RequestMapping("eventCategories")
public class EventCategoriesController {
    /**
     * 服务对象
     */
    @Autowired
    private EventCategoriesService eventcategoriesService;

    /**
     * 分页查询
     *
     * @param eventCategories 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<EventCategories>> queryAllByLimit(EventCategories eventCategories) {
        return ResponseEntity.ok(this.eventcategoriesService.queryAllByLimit(eventCategories));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EventCategories> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.eventcategoriesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param eventcategories 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<EventCategories> add(@RequestBody EventCategories eventcategories) {
        return ResponseEntity.ok(this.eventcategoriesService.insert(eventcategories));
    }

    /**
     * 编辑数据
     *
     * @param eventcategories 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<EventCategories> edit(@RequestBody EventCategories eventcategories) {
        System.out.println(eventcategories);
        return ResponseEntity.ok(this.eventcategoriesService.update(eventcategories));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById( @RequestParam("id") Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(this.eventcategoriesService.deleteById(id));
    }


}

