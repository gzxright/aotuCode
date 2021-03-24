package com.changgou.order.service;
import com.changgou.order.pojo.SsoAccessToken;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoAccessToken业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SsoAccessTokenService {

    /***
     * SsoAccessToken多条件分页查询
     * @param ssoAccessToken
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoAccessToken> findPage(SsoAccessToken ssoAccessToken, int page, int size);

    /***
     * SsoAccessToken分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoAccessToken> findPage(int page, int size);

    /***
     * SsoAccessToken多条件搜索方法
     * @param ssoAccessToken
     * @return
     */
    List<SsoAccessToken> findList(SsoAccessToken ssoAccessToken);

    /***
     * 删除SsoAccessToken
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SsoAccessToken数据
     * @param ssoAccessToken
     */
    void update(SsoAccessToken ssoAccessToken);

    /***
     * 新增SsoAccessToken
     * @param ssoAccessToken
     */
    void add(SsoAccessToken ssoAccessToken);

    /**
     * 根据ID查询SsoAccessToken
     * @param id
     * @return
     */
     SsoAccessToken findById(Integer id);

    /***
     * 查询所有SsoAccessToken
     * @return
     */
    List<SsoAccessToken> findAll();
}
