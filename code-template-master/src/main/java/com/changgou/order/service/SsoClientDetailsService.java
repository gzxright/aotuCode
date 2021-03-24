package com.changgou.order.service;
import com.changgou.order.pojo.SsoClientDetails;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SsoClientDetails业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SsoClientDetailsService {

    /***
     * SsoClientDetails多条件分页查询
     * @param ssoClientDetails
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoClientDetails> findPage(SsoClientDetails ssoClientDetails, int page, int size);

    /***
     * SsoClientDetails分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SsoClientDetails> findPage(int page, int size);

    /***
     * SsoClientDetails多条件搜索方法
     * @param ssoClientDetails
     * @return
     */
    List<SsoClientDetails> findList(SsoClientDetails ssoClientDetails);

    /***
     * 删除SsoClientDetails
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SsoClientDetails数据
     * @param ssoClientDetails
     */
    void update(SsoClientDetails ssoClientDetails);

    /***
     * 新增SsoClientDetails
     * @param ssoClientDetails
     */
    void add(SsoClientDetails ssoClientDetails);

    /**
     * 根据ID查询SsoClientDetails
     * @param id
     * @return
     */
     SsoClientDetails findById(Integer id);

    /***
     * 查询所有SsoClientDetails
     * @return
     */
    List<SsoClientDetails> findAll();
}
