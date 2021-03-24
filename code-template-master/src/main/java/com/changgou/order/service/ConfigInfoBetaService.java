package com.changgou.order.service;
import com.changgou.order.pojo.ConfigInfoBeta;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoBeta业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConfigInfoBetaService {

    /***
     * ConfigInfoBeta多条件分页查询
     * @param configInfoBeta
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoBeta> findPage(ConfigInfoBeta configInfoBeta, int page, int size);

    /***
     * ConfigInfoBeta分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoBeta> findPage(int page, int size);

    /***
     * ConfigInfoBeta多条件搜索方法
     * @param configInfoBeta
     * @return
     */
    List<ConfigInfoBeta> findList(ConfigInfoBeta configInfoBeta);

    /***
     * 删除ConfigInfoBeta
     * @param id
     */
    void delete( id);

    /***
     * 修改ConfigInfoBeta数据
     * @param configInfoBeta
     */
    void update(ConfigInfoBeta configInfoBeta);

    /***
     * 新增ConfigInfoBeta
     * @param configInfoBeta
     */
    void add(ConfigInfoBeta configInfoBeta);

    /**
     * 根据ID查询ConfigInfoBeta
     * @param id
     * @return
     */
     ConfigInfoBeta findById( id);

    /***
     * 查询所有ConfigInfoBeta
     * @return
     */
    List<ConfigInfoBeta> findAll();
}
