package com.changgou.order.service;
import com.changgou.order.pojo.ConfigInfoAggr;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoAggr业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConfigInfoAggrService {

    /***
     * ConfigInfoAggr多条件分页查询
     * @param configInfoAggr
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoAggr> findPage(ConfigInfoAggr configInfoAggr, int page, int size);

    /***
     * ConfigInfoAggr分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoAggr> findPage(int page, int size);

    /***
     * ConfigInfoAggr多条件搜索方法
     * @param configInfoAggr
     * @return
     */
    List<ConfigInfoAggr> findList(ConfigInfoAggr configInfoAggr);

    /***
     * 删除ConfigInfoAggr
     * @param id
     */
    void delete( id);

    /***
     * 修改ConfigInfoAggr数据
     * @param configInfoAggr
     */
    void update(ConfigInfoAggr configInfoAggr);

    /***
     * 新增ConfigInfoAggr
     * @param configInfoAggr
     */
    void add(ConfigInfoAggr configInfoAggr);

    /**
     * 根据ID查询ConfigInfoAggr
     * @param id
     * @return
     */
     ConfigInfoAggr findById( id);

    /***
     * 查询所有ConfigInfoAggr
     * @return
     */
    List<ConfigInfoAggr> findAll();
}
