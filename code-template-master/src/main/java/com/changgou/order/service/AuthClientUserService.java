package com.changgou.order.service;
import com.changgou.order.pojo.AuthClientUser;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthClientUser业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AuthClientUserService {

    /***
     * AuthClientUser多条件分页查询
     * @param authClientUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthClientUser> findPage(AuthClientUser authClientUser, int page, int size);

    /***
     * AuthClientUser分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthClientUser> findPage(int page, int size);

    /***
     * AuthClientUser多条件搜索方法
     * @param authClientUser
     * @return
     */
    List<AuthClientUser> findList(AuthClientUser authClientUser);

    /***
     * 删除AuthClientUser
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AuthClientUser数据
     * @param authClientUser
     */
    void update(AuthClientUser authClientUser);

    /***
     * 新增AuthClientUser
     * @param authClientUser
     */
    void add(AuthClientUser authClientUser);

    /**
     * 根据ID查询AuthClientUser
     * @param id
     * @return
     */
     AuthClientUser findById(Integer id);

    /***
     * 查询所有AuthClientUser
     * @return
     */
    List<AuthClientUser> findAll();
}
