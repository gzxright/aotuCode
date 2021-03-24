package com.changgou.order.service;
import com.changgou.order.pojo.Resource;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Resource业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ResourceService {

    /***
     * Resource多条件分页查询
     * @param resource
     * @param page
     * @param size
     * @return
     */
    PageInfo<Resource> findPage(Resource resource, int page, int size);

    /***
     * Resource分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Resource> findPage(int page, int size);

    /***
     * Resource多条件搜索方法
     * @param resource
     * @return
     */
    List<Resource> findList(Resource resource);

    /***
     * 删除Resource
     * @param id
     */
    void delete( id);

    /***
     * 修改Resource数据
     * @param resource
     */
    void update(Resource resource);

    /***
     * 新增Resource
     * @param resource
     */
    void add(Resource resource);

    /**
     * 根据ID查询Resource
     * @param id
     * @return
     */
     Resource findById( id);

    /***
     * 查询所有Resource
     * @return
     */
    List<Resource> findAll();
}
