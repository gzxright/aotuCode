package com.changgou.order.service;
import com.changgou.order.pojo.Countrylanguage;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Countrylanguage业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface CountrylanguageService {

    /***
     * Countrylanguage多条件分页查询
     * @param countrylanguage
     * @param page
     * @param size
     * @return
     */
    PageInfo<Countrylanguage> findPage(Countrylanguage countrylanguage, int page, int size);

    /***
     * Countrylanguage分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Countrylanguage> findPage(int page, int size);

    /***
     * Countrylanguage多条件搜索方法
     * @param countrylanguage
     * @return
     */
    List<Countrylanguage> findList(Countrylanguage countrylanguage);

    /***
     * 删除Countrylanguage
     * @param id
     */
    void delete( id);

    /***
     * 修改Countrylanguage数据
     * @param countrylanguage
     */
    void update(Countrylanguage countrylanguage);

    /***
     * 新增Countrylanguage
     * @param countrylanguage
     */
    void add(Countrylanguage countrylanguage);

    /**
     * 根据ID查询Countrylanguage
     * @param id
     * @return
     */
     Countrylanguage findById( id);

    /***
     * 查询所有Countrylanguage
     * @return
     */
    List<Countrylanguage> findAll();
}
