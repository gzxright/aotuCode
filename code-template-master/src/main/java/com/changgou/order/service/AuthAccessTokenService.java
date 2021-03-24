package com.changgou.order.service;
import com.changgou.order.pojo.AuthAccessToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthAccessToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AuthAccessTokenService {

    /***
     * AuthAccessToken多条件分页查询
     * @param authAccessToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthAccessToken> findPage(AuthAccessToken authAccessToken, int page, int size);

    /***
     * AuthAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthAccessToken> findPage(int page, int size);

    /***
     * AuthAccessToken多条件搜索方法
     * @param authAccessToken
     * @return
     */
    List<AuthAccessToken> findList(AuthAccessToken authAccessToken);

    /***
     * 删除AuthAccessToken
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AuthAccessToken数据
     * @param authAccessToken
     */
    void update(AuthAccessToken authAccessToken);

    /***
     * 新增AuthAccessToken
     * @param authAccessToken
     */
    void add(AuthAccessToken authAccessToken);

    /**
     * 根据ID查询AuthAccessToken
     * @param id
     * @return
     */
     AuthAccessToken findById(Integer id);

    /***
     * 查询所有AuthAccessToken
     * @return
     */
    List<AuthAccessToken> findAll();
}
