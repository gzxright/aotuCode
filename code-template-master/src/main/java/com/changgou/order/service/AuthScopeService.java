package com.changgou.order.service;
import com.changgou.order.pojo.AuthScope;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthScope业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AuthScopeService {

    /***
     * AuthScope多条件分页查询
     * @param authScope
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthScope> findPage(AuthScope authScope, int page, int size);

    /***
     * AuthScope分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthScope> findPage(int page, int size);

    /***
     * AuthScope多条件搜索方法
     * @param authScope
     * @return
     */
    List<AuthScope> findList(AuthScope authScope);

    /***
     * 删除AuthScope
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AuthScope数据
     * @param authScope
     */
    void update(AuthScope authScope);

    /***
     * 新增AuthScope
     * @param authScope
     */
    void add(AuthScope authScope);

    /**
     * 根据ID查询AuthScope
     * @param id
     * @return
     */
     AuthScope findById(Integer id);

    /***
     * 查询所有AuthScope
     * @return
     */
    List<AuthScope> findAll();
}
