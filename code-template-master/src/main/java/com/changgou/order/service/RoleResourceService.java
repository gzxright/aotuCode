package com.changgou.order.service;
import com.changgou.order.pojo.RoleResource;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:RoleResource业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RoleResourceService {

    /***
     * RoleResource多条件分页查询
     * @param roleResource
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleResource> findPage(RoleResource roleResource, int page, int size);

    /***
     * RoleResource分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleResource> findPage(int page, int size);

    /***
     * RoleResource多条件搜索方法
     * @param roleResource
     * @return
     */
    List<RoleResource> findList(RoleResource roleResource);

    /***
     * 删除RoleResource
     * @param id
     */
    void delete( id);

    /***
     * 修改RoleResource数据
     * @param roleResource
     */
    void update(RoleResource roleResource);

    /***
     * 新增RoleResource
     * @param roleResource
     */
    void add(RoleResource roleResource);

    /**
     * 根据ID查询RoleResource
     * @param id
     * @return
     */
     RoleResource findById( id);

    /***
     * 查询所有RoleResource
     * @return
     */
    List<RoleResource> findAll();
}
