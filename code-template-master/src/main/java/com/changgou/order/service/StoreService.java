package com.changgou.order.service;
import com.changgou.order.pojo.Store;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Store业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface StoreService {

    /***
     * Store多条件分页查询
     * @param store
     * @param page
     * @param size
     * @return
     */
    PageInfo<Store> findPage(Store store, int page, int size);

    /***
     * Store分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Store> findPage(int page, int size);

    /***
     * Store多条件搜索方法
     * @param store
     * @return
     */
    List<Store> findList(Store store);

    /***
     * 删除Store
     * @param id
     */
    void delete( id);

    /***
     * 修改Store数据
     * @param store
     */
    void update(Store store);

    /***
     * 新增Store
     * @param store
     */
    void add(Store store);

    /**
     * 根据ID查询Store
     * @param id
     * @return
     */
     Store findById( id);

    /***
     * 查询所有Store
     * @return
     */
    List<Store> findAll();
}
