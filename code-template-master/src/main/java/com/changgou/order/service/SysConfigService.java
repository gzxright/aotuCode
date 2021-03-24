package com.changgou.order.service;
import com.changgou.order.pojo.SysConfig;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:SysConfig业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysConfigService {

    /***
     * SysConfig多条件分页查询
     * @param sysConfig
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysConfig> findPage(SysConfig sysConfig, int page, int size);

    /***
     * SysConfig分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysConfig> findPage(int page, int size);

    /***
     * SysConfig多条件搜索方法
     * @param sysConfig
     * @return
     */
    List<SysConfig> findList(SysConfig sysConfig);

    /***
     * 删除SysConfig
     * @param id
     */
    void delete( id);

    /***
     * 修改SysConfig数据
     * @param sysConfig
     */
    void update(SysConfig sysConfig);

    /***
     * 新增SysConfig
     * @param sysConfig
     */
    void add(SysConfig sysConfig);

    /**
     * 根据ID查询SysConfig
     * @param id
     * @return
     */
     SysConfig findById( id);

    /***
     * 查询所有SysConfig
     * @return
     */
    List<SysConfig> findAll();
}
