package com.changgou.order.service;
import com.changgou.order.pojo.TenantCapacity;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TenantCapacity业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TenantCapacityService {

    /***
     * TenantCapacity多条件分页查询
     * @param tenantCapacity
     * @param page
     * @param size
     * @return
     */
    PageInfo<TenantCapacity> findPage(TenantCapacity tenantCapacity, int page, int size);

    /***
     * TenantCapacity分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<TenantCapacity> findPage(int page, int size);

    /***
     * TenantCapacity多条件搜索方法
     * @param tenantCapacity
     * @return
     */
    List<TenantCapacity> findList(TenantCapacity tenantCapacity);

    /***
     * 删除TenantCapacity
     * @param id
     */
    void delete( id);

    /***
     * 修改TenantCapacity数据
     * @param tenantCapacity
     */
    void update(TenantCapacity tenantCapacity);

    /***
     * 新增TenantCapacity
     * @param tenantCapacity
     */
    void add(TenantCapacity tenantCapacity);

    /**
     * 根据ID查询TenantCapacity
     * @param id
     * @return
     */
     TenantCapacity findById( id);

    /***
     * 查询所有TenantCapacity
     * @return
     */
    List<TenantCapacity> findAll();
}
