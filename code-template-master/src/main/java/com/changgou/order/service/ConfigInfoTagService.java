package com.changgou.order.service;
import com.changgou.order.pojo.ConfigInfoTag;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:ConfigInfoTag业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface ConfigInfoTagService {

    /***
     * ConfigInfoTag多条件分页查询
     * @param configInfoTag
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoTag> findPage(ConfigInfoTag configInfoTag, int page, int size);

    /***
     * ConfigInfoTag分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<ConfigInfoTag> findPage(int page, int size);

    /***
     * ConfigInfoTag多条件搜索方法
     * @param configInfoTag
     * @return
     */
    List<ConfigInfoTag> findList(ConfigInfoTag configInfoTag);

    /***
     * 删除ConfigInfoTag
     * @param id
     */
    void delete( id);

    /***
     * 修改ConfigInfoTag数据
     * @param configInfoTag
     */
    void update(ConfigInfoTag configInfoTag);

    /***
     * 新增ConfigInfoTag
     * @param configInfoTag
     */
    void add(ConfigInfoTag configInfoTag);

    /**
     * 根据ID查询ConfigInfoTag
     * @param id
     * @return
     */
     ConfigInfoTag findById( id);

    /***
     * 查询所有ConfigInfoTag
     * @return
     */
    List<ConfigInfoTag> findAll();
}
