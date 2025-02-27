package com.senxiu.controller;

import com.github.pagehelper.PageInfo;
import com.senxiu.entity.Events;
import com.senxiu.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.sf.jsqlparser.parser.CCJSqlParserUtil.LOGGER;


/**
 * (Events)表控制层
 *
 * @author makejava
 * @since 2024-12-10 16:33:25
 */
@RestController
@RequestMapping("events")
public class EventsController {
    /**
     * 服务对象
     */
    @Autowired
    private EventsService eventsService;

    /**
     * 分页查询
     *
     * @param events 筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<List<Events>> queryAllByLimit( Events events) {
        return ResponseEntity.ok(this.eventsService.queryAllByLimit(events));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Events> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.eventsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param events 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Events> add(@RequestBody Events events) {
        return ResponseEntity.ok(this.eventsService.insert(events));
    }

    /**
     * 编辑数据
     * @param events 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Events> edit(@RequestBody Events events) {
        System.out.println(events);
        return ResponseEntity.ok(this.eventsService.update(events));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(@RequestParam("id") Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(this.eventsService.deleteById(id));
    }
}

