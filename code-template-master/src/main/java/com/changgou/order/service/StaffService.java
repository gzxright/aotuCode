package com.changgou.order.service;
import com.changgou.order.pojo.Staff;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Staff业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface StaffService {

    /***
     * Staff多条件分页查询
     * @param staff
     * @param page
     * @param size
     * @return
     */
    PageInfo<Staff> findPage(Staff staff, int page, int size);

    /***
     * Staff分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Staff> findPage(int page, int size);

    /***
     * Staff多条件搜索方法
     * @param staff
     * @return
     */
    List<Staff> findList(Staff staff);

    /***
     * 删除Staff
     * @param id
     */
    void delete( id);

    /***
     * 修改Staff数据
     * @param staff
     */
    void update(Staff staff);

    /***
     * 新增Staff
     * @param staff
     */
    void add(Staff staff);

    /**
     * 根据ID查询Staff
     * @param id
     * @return
     */
     Staff findById( id);

    /***
     * 查询所有Staff
     * @return
     */
    List<Staff> findAll();
}
