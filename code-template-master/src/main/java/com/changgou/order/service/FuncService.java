package com.changgou.order.service;
import com.changgou.order.pojo.Func;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Func业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FuncService {

    /***
     * Func多条件分页查询
     * @param func
     * @param page
     * @param size
     * @return
     */
    PageInfo<Func> findPage(Func func, int page, int size);

    /***
     * Func分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Func> findPage(int page, int size);

    /***
     * Func多条件搜索方法
     * @param func
     * @return
     */
    List<Func> findList(Func func);

    /***
     * 删除Func
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Func数据
     * @param func
     */
    void update(Func func);

    /***
     * 新增Func
     * @param func
     */
    void add(Func func);

    /**
     * 根据ID查询Func
     * @param id
     * @return
     */
     Func findById(Integer id);

    /***
     * 查询所有Func
     * @return
     */
    List<Func> findAll();
}
