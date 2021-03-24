package com.changgou.order.service;
import com.changgou.order.pojo.AuthRefreshToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:AuthRefreshToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AuthRefreshTokenService {

    /***
     * AuthRefreshToken多条件分页查询
     * @param authRefreshToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthRefreshToken> findPage(AuthRefreshToken authRefreshToken, int page, int size);

    /***
     * AuthRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AuthRefreshToken> findPage(int page, int size);

    /***
     * AuthRefreshToken多条件搜索方法
     * @param authRefreshToken
     * @return
     */
    List<AuthRefreshToken> findList(AuthRefreshToken authRefreshToken);

    /***
     * 删除AuthRefreshToken
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AuthRefreshToken数据
     * @param authRefreshToken
     */
    void update(AuthRefreshToken authRefreshToken);

    /***
     * 新增AuthRefreshToken
     * @param authRefreshToken
     */
    void add(AuthRefreshToken authRefreshToken);

    /**
     * 根据ID查询AuthRefreshToken
     * @param id
     * @return
     */
     AuthRefreshToken findById(Integer id);

    /***
     * 查询所有AuthRefreshToken
     * @return
     */
    List<AuthRefreshToken> findAll();
}
