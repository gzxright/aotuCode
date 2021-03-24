package com.changgou.order.service;
import com.changgou.order.pojo.Permissions;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Permissions业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PermissionsService {

    /***
     * Permissions多条件分页查询
     * @param permissions
     * @param page
     * @param size
     * @return
     */
    PageInfo<Permissions> findPage(Permissions permissions, int page, int size);

    /***
     * Permissions分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Permissions> findPage(int page, int size);

    /***
     * Permissions多条件搜索方法
     * @param permissions
     * @return
     */
    List<Permissions> findList(Permissions permissions);

    /***
     * 删除Permissions
     * @param id
     */
    void delete( id);

    /***
     * 修改Permissions数据
     * @param permissions
     */
    void update(Permissions permissions);

    /***
     * 新增Permissions
     * @param permissions
     */
    void add(Permissions permissions);

    /**
     * 根据ID查询Permissions
     * @param id
     * @return
     */
     Permissions findById( id);

    /***
     * 查询所有Permissions
     * @return
     */
    List<Permissions> findAll();
}
