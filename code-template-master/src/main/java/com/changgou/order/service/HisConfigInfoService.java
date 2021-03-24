package com.changgou.order.service;
import com.changgou.order.pojo.HisConfigInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:HisConfigInfo业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface HisConfigInfoService {

    /***
     * HisConfigInfo多条件分页查询
     * @param hisConfigInfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<HisConfigInfo> findPage(HisConfigInfo hisConfigInfo, int page, int size);

    /***
     * HisConfigInfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<HisConfigInfo> findPage(int page, int size);

    /***
     * HisConfigInfo多条件搜索方法
     * @param hisConfigInfo
     * @return
     */
    List<HisConfigInfo> findList(HisConfigInfo hisConfigInfo);

    /***
     * 删除HisConfigInfo
     * @param id
     */
    void delete( id);

    /***
     * 修改HisConfigInfo数据
     * @param hisConfigInfo
     */
    void update(HisConfigInfo hisConfigInfo);

    /***
     * 新增HisConfigInfo
     * @param hisConfigInfo
     */
    void add(HisConfigInfo hisConfigInfo);

    /**
     * 根据ID查询HisConfigInfo
     * @param id
     * @return
     */
     HisConfigInfo findById( id);

    /***
     * 查询所有HisConfigInfo
     * @return
     */
    List<HisConfigInfo> findAll();
}
