package com.changgou.order.service;
import com.changgou.order.pojo.GroupCapacity;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:GroupCapacity业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface GroupCapacityService {

    /***
     * GroupCapacity多条件分页查询
     * @param groupCapacity
     * @param page
     * @param size
     * @return
     */
    PageInfo<GroupCapacity> findPage(GroupCapacity groupCapacity, int page, int size);

    /***
     * GroupCapacity分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<GroupCapacity> findPage(int page, int size);

    /***
     * GroupCapacity多条件搜索方法
     * @param groupCapacity
     * @return
     */
    List<GroupCapacity> findList(GroupCapacity groupCapacity);

    /***
     * 删除GroupCapacity
     * @param id
     */
    void delete( id);

    /***
     * 修改GroupCapacity数据
     * @param groupCapacity
     */
    void update(GroupCapacity groupCapacity);

    /***
     * 新增GroupCapacity
     * @param groupCapacity
     */
    void add(GroupCapacity groupCapacity);

    /**
     * 根据ID查询GroupCapacity
     * @param id
     * @return
     */
     GroupCapacity findById( id);

    /***
     * 查询所有GroupCapacity
     * @return
     */
    List<GroupCapacity> findAll();
}
