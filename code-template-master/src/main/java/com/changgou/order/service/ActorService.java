package com.changgou.order.service;
import com.changgou.order.pojo.Actor;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Actor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ActorService {

    /***
     * Actor多条件分页查询
     * @param actor
     * @param page
     * @param size
     * @return
     */
    PageInfo<Actor> findPage(Actor actor, int page, int size);

    /***
     * Actor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Actor> findPage(int page, int size);

    /***
     * Actor多条件搜索方法
     * @param actor
     * @return
     */
    List<Actor> findList(Actor actor);

    /***
     * 删除Actor
     * @param id
     */
    void delete( id);

    /***
     * 修改Actor数据
     * @param actor
     */
    void update(Actor actor);

    /***
     * 新增Actor
     * @param actor
     */
    void add(Actor actor);

    /**
     * 根据ID查询Actor
     * @param id
     * @return
     */
     Actor findById( id);

    /***
     * 查询所有Actor
     * @return
     */
    List<Actor> findAll();
}
