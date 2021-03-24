package com.changgou.order.service;
import com.changgou.order.pojo.Roles;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Roles业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RolesService {

    /***
     * Roles多条件分页查询
     * @param roles
     * @param page
     * @param size
     * @return
     */
    PageInfo<Roles> findPage(Roles roles, int page, int size);

    /***
     * Roles分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Roles> findPage(int page, int size);

    /***
     * Roles多条件搜索方法
     * @param roles
     * @return
     */
    List<Roles> findList(Roles roles);

    /***
     * 删除Roles
     * @param id
     */
    void delete( id);

    /***
     * 修改Roles数据
     * @param roles
     */
    void update(Roles roles);

    /***
     * 新增Roles
     * @param roles
     */
    void add(Roles roles);

    /**
     * 根据ID查询Roles
     * @param id
     * @return
     */
     Roles findById( id);

    /***
     * 查询所有Roles
     * @return
     */
    List<Roles> findAll();
}
