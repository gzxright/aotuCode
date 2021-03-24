package com.changgou.order.service;
import com.changgou.order.pojo.RoleFunc;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:RoleFunc业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RoleFuncService {

    /***
     * RoleFunc多条件分页查询
     * @param roleFunc
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleFunc> findPage(RoleFunc roleFunc, int page, int size);

    /***
     * RoleFunc分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleFunc> findPage(int page, int size);

    /***
     * RoleFunc多条件搜索方法
     * @param roleFunc
     * @return
     */
    List<RoleFunc> findList(RoleFunc roleFunc);

    /***
     * 删除RoleFunc
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改RoleFunc数据
     * @param roleFunc
     */
    void update(RoleFunc roleFunc);

    /***
     * 新增RoleFunc
     * @param roleFunc
     */
    void add(RoleFunc roleFunc);

    /**
     * 根据ID查询RoleFunc
     * @param id
     * @return
     */
     RoleFunc findById(Integer id);

    /***
     * 查询所有RoleFunc
     * @return
     */
    List<RoleFunc> findAll();
}
