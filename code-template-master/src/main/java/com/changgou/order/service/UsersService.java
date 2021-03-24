package com.changgou.order.service;
import com.changgou.order.pojo.Users;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Users业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface UsersService {

    /***
     * Users多条件分页查询
     * @param users
     * @param page
     * @param size
     * @return
     */
    PageInfo<Users> findPage(Users users, int page, int size);

    /***
     * Users分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Users> findPage(int page, int size);

    /***
     * Users多条件搜索方法
     * @param users
     * @return
     */
    List<Users> findList(Users users);

    /***
     * 删除Users
     * @param id
     */
    void delete( id);

    /***
     * 修改Users数据
     * @param users
     */
    void update(Users users);

    /***
     * 新增Users
     * @param users
     */
    void add(Users users);

    /**
     * 根据ID查询Users
     * @param id
     * @return
     */
     Users findById( id);

    /***
     * 查询所有Users
     * @return
     */
    List<Users> findAll();
}
