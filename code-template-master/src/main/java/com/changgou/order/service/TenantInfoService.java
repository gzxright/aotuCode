package com.changgou.order.service;
import com.changgou.order.pojo.TenantInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:TenantInfo业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TenantInfoService {

    /***
     * TenantInfo多条件分页查询
     * @param tenantInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<TenantInfo> findPage(TenantInfo tenantInfo, int page, int size);

    /***
     * TenantInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<TenantInfo> findPage(int page, int size);

    /***
     * TenantInfo多条件搜索方法
     * @param tenantInfo
     * @return
     */
    List<TenantInfo> findList(TenantInfo tenantInfo);

    /***
     * 删除TenantInfo
     * @param id
     */
    void delete( id);

    /***
     * 修改TenantInfo数据
     * @param tenantInfo
     */
    void update(TenantInfo tenantInfo);

    /***
     * 新增TenantInfo
     * @param tenantInfo
     */
    void add(TenantInfo tenantInfo);

    /**
     * 根据ID查询TenantInfo
     * @param id
     * @return
     */
     TenantInfo findById( id);

    /***
     * 查询所有TenantInfo
     * @return
     */
    List<TenantInfo> findAll();
}
