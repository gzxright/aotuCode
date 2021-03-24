package com.changgou.order.service;
import com.changgou.order.pojo.ConfigInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfo业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConfigInfoService {

    /***
     * ConfigInfo多条件分页查询
     * @param configInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfo> findPage(ConfigInfo configInfo, int page, int size);

    /***
     * ConfigInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfo> findPage(int page, int size);

    /***
     * ConfigInfo多条件搜索方法
     * @param configInfo
     * @return
     */
    List<ConfigInfo> findList(ConfigInfo configInfo);

    /***
     * 删除ConfigInfo
     * @param id
     */
    void delete( id);

    /***
     * 修改ConfigInfo数据
     * @param configInfo
     */
    void update(ConfigInfo configInfo);

    /***
     * 新增ConfigInfo
     * @param configInfo
     */
    void add(ConfigInfo configInfo);

    /**
     * 根据ID查询ConfigInfo
     * @param id
     * @return
     */
     ConfigInfo findById( id);

    /***
     * 查询所有ConfigInfo
     * @return
     */
    List<ConfigInfo> findAll();
}
