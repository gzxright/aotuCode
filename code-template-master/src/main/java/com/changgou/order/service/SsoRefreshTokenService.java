package com.changgou.order.service;
import com.changgou.order.pojo.SsoRefreshToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoRefreshToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SsoRefreshTokenService {

    /***
     * SsoRefreshToken多条件分页查询
     * @param ssoRefreshToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoRefreshToken> findPage(SsoRefreshToken ssoRefreshToken, int page, int size);

    /***
     * SsoRefreshToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoRefreshToken> findPage(int page, int size);

    /***
     * SsoRefreshToken多条件搜索方法
     * @param ssoRefreshToken
     * @return
     */
    List<SsoRefreshToken> findList(SsoRefreshToken ssoRefreshToken);

    /***
     * 删除SsoRefreshToken
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SsoRefreshToken数据
     * @param ssoRefreshToken
     */
    void update(SsoRefreshToken ssoRefreshToken);

    /***
     * 新增SsoRefreshToken
     * @param ssoRefreshToken
     */
    void add(SsoRefreshToken ssoRefreshToken);

    /**
     * 根据ID查询SsoRefreshToken
     * @param id
     * @return
     */
     SsoRefreshToken findById(Integer id);

    /***
     * 查询所有SsoRefreshToken
     * @return
     */
    List<SsoRefreshToken> findAll();
}
