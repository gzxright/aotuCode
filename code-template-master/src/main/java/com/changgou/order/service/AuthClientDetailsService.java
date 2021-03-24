package com.changgou.order.service;
import com.changgou.order.pojo.AuthClientDetails;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthClientDetails业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AuthClientDetailsService {

    /***
     * AuthClientDetails多条件分页查询
     * @param authClientDetails
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthClientDetails> findPage(AuthClientDetails authClientDetails, int page, int size);

    /***
     * AuthClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthClientDetails> findPage(int page, int size);

    /***
     * AuthClientDetails多条件搜索方法
     * @param authClientDetails
     * @return
     */
    List<AuthClientDetails> findList(AuthClientDetails authClientDetails);

    /***
     * 删除AuthClientDetails
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AuthClientDetails数据
     * @param authClientDetails
     */
    void update(AuthClientDetails authClientDetails);

    /***
     * 新增AuthClientDetails
     * @param authClientDetails
     */
    void add(AuthClientDetails authClientDetails);

    /**
     * 根据ID查询AuthClientDetails
     * @param id
     * @return
     */
     AuthClientDetails findById(Integer id);

    /***
     * 查询所有AuthClientDetails
     * @return
     */
    List<AuthClientDetails> findAll();
}
