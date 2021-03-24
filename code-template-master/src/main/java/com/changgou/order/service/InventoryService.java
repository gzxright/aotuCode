package com.changgou.order.service;
import com.changgou.order.pojo.Inventory;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Inventory业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface InventoryService {

    /***
     * Inventory多条件分页查询
     * @param inventory
     * @param page
     * @param size
     * @return
     */
    PageInfo<Inventory> findPage(Inventory inventory, int page, int size);

    /***
     * Inventory分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Inventory> findPage(int page, int size);

    /***
     * Inventory多条件搜索方法
     * @param inventory
     * @return
     */
    List<Inventory> findList(Inventory inventory);

    /***
     * 删除Inventory
     * @param id
     */
    void delete( id);

    /***
     * 修改Inventory数据
     * @param inventory
     */
    void update(Inventory inventory);

    /***
     * 新增Inventory
     * @param inventory
     */
    void add(Inventory inventory);

    /**
     * 根据ID查询Inventory
     * @param id
     * @return
     */
     Inventory findById( id);

    /***
     * 查询所有Inventory
     * @return
     */
    List<Inventory> findAll();
}
